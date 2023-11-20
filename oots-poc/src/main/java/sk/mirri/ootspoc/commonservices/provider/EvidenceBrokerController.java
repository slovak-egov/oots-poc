package sk.mirri.ootspoc.commonservices.provider;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.camel.CamelContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

@RestController
public class EvidenceBrokerController {

	@Autowired
	private CamelContext camelContext;

	@Autowired
	private RestTemplate restTemplate;

	// TODO toto oddelit uplne do samostatnej appky

	/**
	 * 
	 * lookup request
	 * https://projectathon.oots-common-services.eu/query/eb/rest/search?queryId=urn:fdc:oots:eb:ebxml-regrep:queries:requirements-by-procedure-and-jurisdiction&procedure-id=T2&country-code=SK
	 * lookup evidence type
	 * https://projectathon.oots-common-services.eu/query/eb/rest/search?queryId=urn:fdc:oots:eb:ebxml-regrep:queries:evidence-types-by-requirement-and-jurisdiction&country-code=CZ&requirement-id=https://sr.oots.tech.ec.europa.eu/requirements/f8a6a284-34e9-42c7-9733-63b5c4f4aa42
	 */

	@RequestMapping("/commonservices/lookup/request/{countryCode}/{procedureId}")
	public String lookupRequest(@PathVariable String countryCode, @PathVariable String procedureId) {
		String queryUrl = "https://projectathon.oots-common-services.eu/query/eb/rest/search?queryId=urn:fdc:oots:eb:ebxml-regrep:queries:requirements-by-procedure-and-jurisdiction&procedure-id="
				+ procedureId + "&country-code=" + countryCode;
		String result = restTemplate.getForObject(queryUrl, String.class);
		// Process the result here
		return result;
	}

	@RequestMapping("/commonservices/lookup/evidencetype/{countryCode}")
	public String lookupEvidenceType(@PathVariable String countryCode,
			@RequestParam("requirementId") String requirementId) {
		String queryUrl = "https://projectathon.oots-common-services.eu/query/eb/rest/search?queryId=urn:fdc:oots:eb:ebxml-regrep:queries:evidence-types-by-requirement-and-jurisdiction&country-code="
				+ countryCode + "&requirement-id=" + requirementId;
		String result = restTemplate.getForObject(queryUrl, String.class);
		// Process the result here
		return result;
	}

//	@RequestMapping("/commonservices/eb/lookup/countryCodes")
//	public String lookupCountryCodes() {
//		String queryUrl = "https://projectathon.oots-common-services.eu/query/eb/rest/search?queryId=urn:fdc:oots:eb:ebxml-regrep:queries:requirements-by-procedure-and-jurisdiction";
//		QueryResponse document = restTemplate.getForObject(queryUrl, QueryResponse.class);
//		String response = document.getRegistryObjectList().toString();
//		// Process the result here
//		return response;
//	}

	@RequestMapping("/commonservices/eb/lookup/countryCodes")
	public String lookupCountryCodes() {
		String queryUrl = "https://projectathon.oots-common-services.eu/query/eb/rest/search?queryId=urn:fdc:oots:eb:ebxml-regrep:queries:requirements-by-procedure-and-jurisdiction";

		try {
			// Create a DocumentBuilder
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();

			// Parse the XML from the URL
			Document doc = builder.parse(queryUrl);

			// Get the NodeList of oots:AdminUnitLevel1 elements
			NodeList adminUnitLevel1Elements = doc.getElementsByTagName("oots:AdminUnitLevel1");

			// Iterate through the oots:AdminUnitLevel1 elements
			Set<String> countryCodes = new HashSet<String>();
			for (int i = 0; i < adminUnitLevel1Elements.getLength(); i++) {
				Node adminUnitLevel1 = adminUnitLevel1Elements.item(i);

				// Get the text content of the oots:AdminUnitLevel1 element
				String adminUnitLevel1Value = adminUnitLevel1.getTextContent();

				// Append the value to your response
				countryCodes.add(adminUnitLevel1Value);
			}

			// You can return the response as a String
			return countryCodes.stream().sorted().collect(Collectors.joining());

		} catch (ParserConfigurationException | SAXException | IOException e) {
			// Handle exceptions
			e.printStackTrace();
			return "Error while processing XML.";
		}
	}

	@RequestMapping("/commonservices/eb/lookup/procedureTypes/{countryCode}")
	public String lookupProcedureTypes(@PathVariable String countryCode) {
		String queryUrl = "https://projectathon.oots-common-services.eu/query/eb/rest/search?queryId=urn:fdc:oots:eb:ebxml-regrep:queries:requirements-by-procedure-and-jurisdiction&country-code="
				+ countryCode;

		try {
			// Create a DocumentBuilder
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();

			// Parse the XML from the URL
			Document doc = builder.parse(queryUrl);

			// Get the NodeList of oots:Identifier elements within oots:RelatedTo
			NodeList relatedToIdentifierElements = doc.getElementsByTagName("oots:RelatedTo");

			// Iterate through the relatedToIdentifier elements
			Set<String> procedureTypes = new HashSet<String>();
			for (int i = 0; i < relatedToIdentifierElements.getLength(); i++) {
				Node identifierNode = relatedToIdentifierElements.item(i);

				// Get the text content of the oots:Identifier element within oots:RelatedTo
				String identifierValue = identifierNode.getTextContent().trim();

				// Append the value to your response
				procedureTypes.add(identifierValue);
			}

			// You can return the response as a String
			return procedureTypes.stream().sorted().collect(Collectors.joining());

		} catch (ParserConfigurationException | SAXException | IOException e) {
			// Handle exceptions
			e.printStackTrace();
			return "Error while processing XML.";
		}
	}

	@RequestMapping("/commonservices/eb/lookup/requirements/{countryCode}/{procedureId}")
	public String lookupProcedureTypes(@PathVariable String countryCode, @PathVariable String procedureId) {
		String queryUrl = "https://projectathon.oots-common-services.eu/query/eb/rest/search?queryId=urn:fdc:oots:eb:ebxml-regrep:queries:requirements-by-procedure-and-jurisdiction&country-code="
				+ countryCode + "&procedure-id=" + procedureId;

		try {
			// Create a DocumentBuilder
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();

			// Parse the XML from the URL
			Document doc = builder.parse(queryUrl);

			// Get the NodeList of oots:Identifier elements within oots:RelatedTo
			NodeList relatedToIdentifierElements = doc.getElementsByTagName("oots:Requirement");

			// Iterate through the relatedToIdentifier elements
			Set<String> requirements = new HashSet<String>();
			for (int i = 0; i < relatedToIdentifierElements.getLength(); i++) {
				Node identifierNode = relatedToIdentifierElements.item(i);

				// Get the text content of the oots:Identifier element within oots:RelatedTo
				String identifierValue = identifierNode.getTextContent().trim();

				// Append the value to your response
				requirements.add(identifierValue);
			}

			// You can return the response as a String
			return requirements.stream().sorted().collect(Collectors.joining());

		} catch (ParserConfigurationException | SAXException | IOException e) {
			// Handle exceptions
			e.printStackTrace();
			return "Error while processing XML.";
		}
	}

}