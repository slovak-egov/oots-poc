package sk.mirri.ootsevidencefinder.controllers;

import eu.europa.oots.binding.regrep.query.QueryResponse;
import eu.europa.oots.binding.regrep.rim.AnyValueType;
import eu.europa.oots.binding.regrep.rim.RegistryObjectType;
import eu.europa.oots.binding.sdg.DataServiceEvidenceTypeType;
import eu.europa.oots.binding.sdg.DataServiceType;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.JAXBException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import sk.mirri.ootsevidencefinder.evidencebroker.data.EvidenceProvider;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.stream.Collectors;

@Tag(name = "Data Service Directory"/*, tags = { "Data Service Directory" }*/)
@RestController
@RequestMapping("/commonservices/dsd")
public class DataServiceDirectoryController extends RegrepService {

    private static Logger LOGGER = LoggerFactory.getLogger(EvidenceBrokerController.class);


    @Value("${dsd.url}")
    private String commonservicesUrl;

    @Operation(summary = "Vyhľadať poskytovateľov dôkazov", description = "Získa zoznam poskytovateľov dôkazov pre konkrétnu krajinu a typ dôkazu.")
    @GetMapping("/lookup/dataServices/{countryCode}")
    public List<EvidenceProvider> lookupEvidenceProviders(@PathVariable String countryCode,
                                                          @RequestParam("evidenceType") String evidenceType) throws IOException, JAXBException {
        String queryUrl = commonservicesUrl
                + "?queryId=urn:fdc:oots:dsd:ebxml-regrep:queries:dataservices-by-evidencetype-and-jurisdiction&country-code="
                + countryCode + "&evidence-type-classification=" + evidenceType;

        URL url = new URL(queryUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        // connection.setConnectTimeout(5000);
        // connection.setReadTimeout(5000);

        int responseCode = connection.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK) {
            connection.getInputStream();
        } else {
            throw new IOException("Failed to fetch data from URL. Response code: " + responseCode);
        }

        QueryResponse resp = parseFromInput(connection.getInputStream());

        if (resp == null || !resp.getStatus().contains("Success")) {
            LOGGER.info("Status {}", resp.getStatus());
            return null;
        }

        List<RegistryObjectType> registryObjectTypes = resp.getRegistryObjectList().getRegistryObject();

        return registryObjectTypes.stream().flatMap(item ->
        {
            var el = (JAXBElement<DataServiceEvidenceTypeType>) ((AnyValueType) item.getSlot().get(0).getSlotValue()).getAny();
            return el.getValue().getAccessService().stream().map(DataServiceType::getPublisher).map(publisherType -> {
                return new EvidenceProvider(publisherType.getIdentifier().getValue(), publisherType.getName().get(0).getValue());
            });
        }).distinct().collect(Collectors.toList());

    }
}