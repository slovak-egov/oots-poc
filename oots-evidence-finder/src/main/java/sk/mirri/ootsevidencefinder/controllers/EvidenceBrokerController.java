package sk.mirri.ootsevidencefinder.controllers;

import eu.europa.oots.binding.regrep.query.QueryResponse;
import eu.europa.oots.binding.regrep.rim.AnyValueType;
import eu.europa.oots.binding.regrep.rim.RegistryObjectType;
import eu.europa.oots.binding.sdg.EvidenceTypeListType;
import eu.europa.oots.binding.sdg.RequirementType;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.JAXBException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import sk.mirri.ootsevidencefinder.evidencebroker.data.CountryCode;
import sk.mirri.ootsevidencefinder.evidencebroker.data.EvidenceType;
import sk.mirri.ootsevidencefinder.evidencebroker.data.ProcedureType;
import sk.mirri.ootsevidencefinder.evidencebroker.data.Requirement;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Tag(name = "Evidence Broker"/*, tags = {"Evidence Broker"}*/)
@RestController
@RequestMapping("/commonservices/eb")
public class EvidenceBrokerController extends RegrepService {

    private static Logger LOGGER = LoggerFactory.getLogger(EvidenceBrokerController.class);
    private final Map<String, String> countryCodeMap;


    @Value("${eb.url}")
    private String commonservicesUrl;

    @Autowired
    public EvidenceBrokerController(Map<String, String> countryCodeMap) {
        this.countryCodeMap = countryCodeMap;
    }

    @Operation(summary = "Vyhľadať zoznam krajín", description = "Získa zoznam krajín.")
    @GetMapping("/lookup/countryCodes")
    public List<CountryCode> lookupCountryCodes() throws IOException, JAXBException {
        String queryUrl = commonservicesUrl
                + "?queryId=urn:fdc:oots:eb:ebxml-regrep:queries:requirements-by-procedure-and-jurisdiction";

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
            var el = (JAXBElement<RequirementType>) ((AnyValueType) item.getSlot().get(0).getSlotValue()).getAny();
            return el.getValue().getReferenceFramework().stream().flatMap(referenceFrameworkType -> {
                return referenceFrameworkType.getJurisdiction().stream().map(jurisdictionType -> {
                    return new CountryCode(jurisdictionType.getAdminUnitLevel1().getValue(), countryCodeMap.getOrDefault(jurisdictionType.getAdminUnitLevel1().getValue(), jurisdictionType.getAdminUnitLevel1().getValue()));
                }).distinct();
            }).distinct();
        }).distinct().collect(Collectors.toList());
    }

    @CrossOrigin(origins = "*")
    @Operation(summary = "Vyhľadať zoznam krajín pre procedúru", description = "Získa zoznam krajín pre danú procedúru.")
    @GetMapping("/lookup/countryCodes/{procedureId}")
    public List<CountryCode> lookupCountryCodesForProcedure(@PathVariable String procedureId) throws IOException, JAXBException {
        String queryUrl = commonservicesUrl
                + "?queryId=urn:fdc:oots:eb:ebxml-regrep:queries:requirements-by-procedure-and-jurisdiction&procedure-id="
                + procedureId;

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
            var el = (JAXBElement<RequirementType>) ((AnyValueType) item.getSlot().get(0).getSlotValue()).getAny();
            return el.getValue().getReferenceFramework().stream().flatMap(referenceFrameworkType -> {
                return referenceFrameworkType.getJurisdiction().stream().map(jurisdictionType -> {
                    return new CountryCode(jurisdictionType.getAdminUnitLevel1().getValue(), countryCodeMap.getOrDefault(jurisdictionType.getAdminUnitLevel1().getValue(), jurisdictionType.getAdminUnitLevel1().getValue()));
                }).distinct();
            }).distinct();
        }).distinct().collect(Collectors.toList());

    }

    @Operation(summary = "Vyhľadať zoznam typov procedúr", description = "Získa zoznam procedúr pre konkrétnu krajinu.")
    @GetMapping("/lookup/procedureTypes/{countryCode}")
    public List<ProcedureType> lookupProcedureTypes(@PathVariable String countryCode) throws IOException, JAXBException {
        String queryUrl = commonservicesUrl
                + "?queryId=urn:fdc:oots:eb:ebxml-regrep:queries:requirements-by-procedure-and-jurisdiction&country-code="
                + countryCode;

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
            var el = (JAXBElement<RequirementType>) ((AnyValueType) item.getSlot().get(0).getSlotValue()).getAny();
            return el.getValue().getReferenceFramework().stream().flatMap(referenceFrameworkType -> {
                return referenceFrameworkType.getRelatedTo().stream().map(relatedTo -> {
                    return new ProcedureType(relatedTo.getIdentifier().getValue(), referenceFrameworkType.getTitle().get(0).getValue());
                }).distinct();
            });
        }).distinct().collect(Collectors.toList());
    }

    @Operation(summary = "Vyhľadať požiadavky", description = "Získa zoznam požiadaviek pre konkrétnu krajinu a identifikátor procedúry.")
    @GetMapping("/lookup/requirements/{countryCode}/{procedureId}")
    public List<Requirement> lookupRequirements(@PathVariable String countryCode, @PathVariable String procedureId) throws IOException, JAXBException {
        String queryUrl = commonservicesUrl
                + "?queryId=urn:fdc:oots:eb:ebxml-regrep:queries:requirements-by-procedure-and-jurisdiction&country-code="
                + countryCode + "&procedure-id=" + procedureId;

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

        return registryObjectTypes.stream().map(item ->
        {
            var el = (JAXBElement<RequirementType>) ((AnyValueType) item.getSlot().get(0).getSlotValue()).getAny();
            return new Requirement(el.getValue().getIdentifier().getValue(), el.getValue().getName().get(0).getValue());//el.getValue();
        }).collect(Collectors.toList());
    }

    @Operation(summary = "Vyhľadať zoznam typov dôkazov", description = "Získa zoznam typov dôkazov pre konkrétnu krajinu a identifikátor požiadavky.")
    @GetMapping("/lookup/evidenceTypes/{countryCode}")
    public List<EvidenceType> lookupEvidenceTypes(@PathVariable String countryCode,
                                                  @RequestParam("requirementId") String requirementId) throws IOException, JAXBException {
        String queryUrl = commonservicesUrl
                + "?queryId=urn:fdc:oots:eb:ebxml-regrep:queries:evidence-types-by-requirement-and-jurisdiction&country-code="
                + countryCode + "&requirement-id=" + requirementId;

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
            var el = (JAXBElement<RequirementType>) ((AnyValueType) item.getSlot().get(0).getSlotValue()).getAny();
            return el.getValue().getEvidenceTypeList().stream().map(EvidenceTypeListType::getEvidenceType).flatMap(List::stream).map(evidenceTypeType -> {
                return new EvidenceType(evidenceTypeType.getEvidenceTypeClassification(), evidenceTypeType.getTitle().get(0).getValue());
            });
        }).distinct().collect(Collectors.toList());
    }

    @Operation(summary = "Vyhľadať zoznam typov dôkazov", description = "Získa zoznam typov dôkazov pre konkrétnu krajinu a identifikátor požiadavky.")
    @GetMapping("/lookup/evidenceTypes/{countryCode}/{procedureId}")
    public List<EvidenceType> lookupEvidenceTypesForProcedures(@PathVariable String countryCode,
                                                               @PathVariable String procedureId) throws IOException, JAXBException {
        List<Requirement> requirements = lookupRequirements(countryCode, procedureId);

        Set<EvidenceType> evidenceTypes = new HashSet<>();
        for (Requirement requirement : requirements) {
            evidenceTypes.addAll(lookupEvidenceTypes(countryCode, requirement.getId()));
        }
        return evidenceTypes.stream().toList();
    }
}