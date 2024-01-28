package sk.mirri.ootsevidencefinder.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import sk.mirri.ootsevidencefinder.evidencebroker.data.EvidenceProvider;
import sk.mirri.ootsevidencefinder.evidencebroker.data.EvidenceProvidersResponse;

@Api(value = "Data Service Directory", tags = { "Data Service Directory" })
@RestController
@RequestMapping("/commonservices/dsd")
public class DataServiceDirectoryController {

	@Value("${dsd.url}")
	private String commonservicesUrl;

	@ApiOperation(value = "Vyhľadať poskytovateľov dôkazov", notes = "Získa zoznam poskytovateľov dôkazov pre konkrétnu krajinu a typ dôkazu.")
	@GetMapping("/lookup/dataServices/{countryCode}")
	public EvidenceProvidersResponse lookupEvidenceProviders(@PathVariable String countryCode,
			@RequestParam("evidenceType") String evidenceType) {
		String queryUrl = commonservicesUrl
				+ "?queryId=urn:fdc:oots:dsd:ebxml-regrep:queries:dataservices-by-evidencetype-and-jurisdiction&country-code="
				+ countryCode + "&evidence-type-classification=" + evidenceType;

		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse(queryUrl);

			NodeList evidenceTypeElements = doc.getElementsByTagName("oots:AccessService");

			List<EvidenceProvider> evidenceProviders = new ArrayList<>();

			for (int i = 0; i < evidenceTypeElements.getLength(); i++) {
				Node evidenceTypeNode = evidenceTypeElements.item(i);

				if (evidenceTypeNode.getNodeType() == Node.ELEMENT_NODE) {
					Element evidenceTypeElement = (Element) evidenceTypeNode;

					String identifier = evidenceTypeElement.getElementsByTagName("oots:Identifier").item(0)
							.getTextContent().trim();
					String name = evidenceTypeElement.getElementsByTagName("oots:Name").item(0).getTextContent().trim();

					evidenceProviders.add(new EvidenceProvider(identifier, name));
				}
			}

			return new EvidenceProvidersResponse(evidenceProviders);

		} catch (ParserConfigurationException | SAXException | IOException e) {
			e.printStackTrace();
			return new EvidenceProvidersResponse();
		}
	}
}