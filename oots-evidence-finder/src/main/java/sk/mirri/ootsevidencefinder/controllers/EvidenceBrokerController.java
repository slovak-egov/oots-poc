package sk.mirri.ootsevidencefinder.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

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
import sk.mirri.ootsevidencefinder.evidencebroker.data.CountryCodesResponse;
import sk.mirri.ootsevidencefinder.evidencebroker.data.EvidenceType;
import sk.mirri.ootsevidencefinder.evidencebroker.data.EvidenceTypesResponse;
import sk.mirri.ootsevidencefinder.evidencebroker.data.ProcedureType;
import sk.mirri.ootsevidencefinder.evidencebroker.data.ProcedureTypesResponse;
import sk.mirri.ootsevidencefinder.evidencebroker.data.Requirement;
import sk.mirri.ootsevidencefinder.evidencebroker.data.RequirementsResponse;

@Api(value = "Evidence Broker", tags = { "Evidence Broker" })
@RestController
@RequestMapping("/commonservices/eb")
public class EvidenceBrokerController {

	@ApiOperation(value = "Lookup Country Codes", notes = "Retrieve a list of country codes.")
	@GetMapping("/lookup/countryCodes")
	public CountryCodesResponse lookupCountryCodes() {
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
			return new CountryCodesResponse(countryCodes.stream().sorted().collect(Collectors.toList()));

		} catch (ParserConfigurationException | SAXException | IOException e) {
			// Handle exceptions
			e.printStackTrace();
			return new CountryCodesResponse();
		}
	}

	@ApiOperation(value = "Lookup Procedure Types", notes = "Retrieve procedure types for a specific country code.")
	@GetMapping("/lookup/procedureTypes/{countryCode}")
	public ProcedureTypesResponse lookupProcedureTypes(@PathVariable String countryCode) {
		String queryUrl = "https://projectathon.oots-common-services.eu/query/eb/rest/search?queryId=urn:fdc:oots:eb:ebxml-regrep:queries:requirements-by-procedure-and-jurisdiction&country-code="
				+ countryCode;

		try {
			// Create a DocumentBuilder
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();

			// Parse the XML from the URL
			Document doc = builder.parse(queryUrl);

			// Get the NodeList of oots:Requirement elements
			NodeList requirementElements = doc.getElementsByTagName("oots:ReferenceFramework");

			// Create a list to store the requirement information
			List<ProcedureType> requirements = new ArrayList<>();

			// Iterate through the requirement elements
			for (int i = 0; i < requirementElements.getLength(); i++) {
				Node requirementNode = requirementElements.item(i);

				if (requirementNode.getNodeType() == Node.ELEMENT_NODE) {
					Element requirementElement = (Element) requirementNode;

					// Get the "Identifier" and "Name" elements within the "oots:Requirement"
					// element
					String identifier = requirementElement.getElementsByTagName("oots:RelatedTo").item(0)
							.getTextContent().trim();
					String name = requirementElement.getElementsByTagName("oots:Title").item(0).getTextContent().trim();

					// Create a RequirementInfo object and add it to the list
					requirements.add(new ProcedureType(identifier, name));
				}
			}

			// You can return the list of RequirementInfo objects
			return new ProcedureTypesResponse(requirements);

		} catch (ParserConfigurationException | SAXException | IOException e) {
			// Handle exceptions
			e.printStackTrace();
			return new ProcedureTypesResponse();
		}
	}

//	@ApiOperation(value = "Lookup Requirements", notes = "Retrieve requirements for a specific country code and procedure ID.")
//	@GetMapping("/lookup/requirements/{countryCode}/{procedureId}")
//	public String lookupRequirements(@PathVariable String countryCode, @PathVariable String procedureId) {
//		String queryUrl = "https://projectathon.oots-common-services.eu/query/eb/rest/search?queryId=urn:fdc:oots:eb:ebxml-regrep:queries:requirements-by-procedure-and-jurisdiction&country-code="
//				+ countryCode + "&procedure-id=" + procedureId;
//
//		try {
//			// Create a DocumentBuilder
//			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
//			DocumentBuilder builder = factory.newDocumentBuilder();
//
//			// Parse the XML from the URL
//			Document doc = builder.parse(queryUrl);
//
//			// Get the NodeList of oots:Identifier elements within oots:RelatedTo
//			NodeList relatedToIdentifierElements = doc.getElementsByTagName("oots:Requirement");
//
//			// Iterate through the relatedToIdentifier elements
//			Set<String> requirements = new HashSet<String>();
//			for (int i = 0; i < relatedToIdentifierElements.getLength(); i++) {
//				Node identifierNode = relatedToIdentifierElements.item(i);
//
//				// Get the text content of the oots:Identifier element within oots:RelatedTo
//				String identifierValue = identifierNode.getTextContent().trim();
//
//				// Append the value to your response
//				requirements.add(identifierValue);
//			}
//
//			// You can return the response as a String
//			return requirements.stream().sorted().collect(Collectors.joining());
//
//		} catch (ParserConfigurationException | SAXException | IOException e) {
//			// Handle exceptions
//			e.printStackTrace();
//			return "";
//		}
//	}

	@ApiOperation(value = "Lookup Requirements", notes = "Retrieve requirements for a specific country code and procedure ID.")
	@GetMapping("/lookup/requirements/{countryCode}/{procedureId}")
	public RequirementsResponse lookupRequirements(@PathVariable String countryCode, @PathVariable String procedureId) {
		String queryUrl = "https://projectathon.oots-common-services.eu/query/eb/rest/search?queryId=urn:fdc:oots:eb:ebxml-regrep:queries:requirements-by-procedure-and-jurisdiction&country-code="
				+ countryCode + "&procedure-id=" + procedureId;

		try {
			// Create a DocumentBuilder
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();

			// Parse the XML from the URL
			Document doc = builder.parse(queryUrl);

			// Get the NodeList of oots:Requirement elements
			NodeList requirementElements = doc.getElementsByTagName("oots:Requirement");

			// Create a list to store the requirement information
			List<Requirement> requirements = new ArrayList<>();

			// Iterate through the requirement elements
			for (int i = 0; i < requirementElements.getLength(); i++) {
				Node requirementNode = requirementElements.item(i);

				if (requirementNode.getNodeType() == Node.ELEMENT_NODE) {
					Element requirementElement = (Element) requirementNode;

					// Get the "Identifier" and "Name" elements within the "oots:Requirement"
					// element
					String identifier = requirementElement.getElementsByTagName("oots:Identifier").item(0)
							.getTextContent().trim();
					String name = requirementElement.getElementsByTagName("oots:Name").item(0).getTextContent().trim();

					// Create a RequirementInfo object and add it to the list
					requirements.add(new Requirement(identifier, name));
				}
			}

			// You can return the list of RequirementInfo objects
			return new RequirementsResponse(requirements);

		} catch (ParserConfigurationException | SAXException | IOException e) {
			// Handle exceptions
			e.printStackTrace();
			return new RequirementsResponse();
		}

	}

	@ApiOperation(value = "Lookup Evidence Types", notes = "Retrieve evidence types for a specific country code and requirement.")
	@GetMapping("/lookup/evidenceTypes/{countryCode}")
	public EvidenceTypesResponse lookupEvidenceTypes(@PathVariable String countryCode,
			@RequestParam("requirementId") String requirementId) {
		String queryUrl = "https://projectathon.oots-common-services.eu/query/eb/rest/search?queryId=urn:fdc:oots:eb:ebxml-regrep:queries:evidence-types-by-requirement-and-jurisdiction&country-code="
				+ countryCode + "&requirement-id=" + requirementId;

		try {
			// Create a DocumentBuilder
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();

			// Parse the XML from the URL
			Document doc = builder.parse(queryUrl);

			// Get the NodeList of oots:Requirement elements
			NodeList evidenceTypeElements = doc.getElementsByTagName("oots:EvidenceType");

			// Create a list to store the requirement information
			List<EvidenceType> evidenceTypes = new ArrayList<>();

			// Iterate through the requirement elements
			for (int i = 0; i < evidenceTypeElements.getLength(); i++) {
				Node evidenceTypeNode = evidenceTypeElements.item(i);

				if (evidenceTypeNode.getNodeType() == Node.ELEMENT_NODE) {
					Element evidenceTypeElement = (Element) evidenceTypeNode;

					// Get the "Identifier" and "Name" elements within the "oots:Requirement"
					// element
					String identifier = evidenceTypeElement.getElementsByTagName("oots:EvidenceTypeClassification")
							.item(0).getTextContent().trim();
					String name = evidenceTypeElement.getElementsByTagName("oots:Title").item(0).getTextContent()
							.trim();

					// Create a RequirementInfo object and add it to the list
					evidenceTypes.add(new EvidenceType(identifier, name));
				}
			}

			// You can return the list of RequirementInfo objects
			return new EvidenceTypesResponse(evidenceTypes);

		} catch (ParserConfigurationException | SAXException | IOException e) {
			// Handle exceptions
			e.printStackTrace();
			return new EvidenceTypesResponse();
		}
	}
}