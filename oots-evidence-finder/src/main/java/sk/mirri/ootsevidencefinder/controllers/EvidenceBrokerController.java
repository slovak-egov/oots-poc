package sk.mirri.ootsevidencefinder.controllers;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.*;
import java.util.stream.Collectors;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import sk.mirri.ootsevidencefinder.evidencebroker.data.CountryCode;
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

	private static Logger LOGGER = LoggerFactory.getLogger(EvidenceBrokerController.class);
	private final Map<String, String> countryCodeMap;

	@Value("${eb.url}")
	private String commonservicesUrl;

	@Autowired
	public EvidenceBrokerController(Map<String, String> countryCodeMap) {
		this.countryCodeMap = countryCodeMap;
	}

	@ApiOperation(value = "Vyhľadať zoznam krajín", notes = "Získa zoznam krajín.")
	@GetMapping("/lookup/countryCodes")
	public List<CountryCode> lookupCountryCodes() {
		String queryUrl = commonservicesUrl
				+ "?queryId=urn:fdc:oots:eb:ebxml-regrep:queries:requirements-by-procedure-and-jurisdiction";

		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse(queryUrl);
			NodeList adminUnitLevel1Elements = doc.getElementsByTagName("oots:AdminUnitLevel1");

			// Iterate through the oots:AdminUnitLevel1 elements
			Set<String> countryCodes = new HashSet<String>();
			for (int i = 0; i < adminUnitLevel1Elements.getLength(); i++) {
				Node adminUnitLevel1 = adminUnitLevel1Elements.item(i);
				String adminUnitLevel1Value = adminUnitLevel1.getTextContent();
				countryCodes.add(adminUnitLevel1Value);
			}

			return countryCodes.stream().sorted()
					.map(item -> new CountryCode(item, countryCodeMap.getOrDefault(item, item)))
					.collect(Collectors.toList());

		} catch (ParserConfigurationException | SAXException | IOException e) {
			e.printStackTrace();
			return Collections.emptyList();
		}
	}

	@CrossOrigin(origins = "*")
	@ApiOperation(value = "Vyhľadať zoznam krajín pre procedúru", notes = "Získa zoznam krajín pre danú procedúru.")
	@GetMapping("/lookup/countryCodes/{procedureId}")
	public List<CountryCode> lookupCountryCodesForProcedure(@PathVariable String procedureId) {
		String queryUrl = commonservicesUrl
				+ "/query/eb/rest/search?queryId=urn:fdc:oots:eb:ebxml-regrep:queries:requirements-by-procedure-and-jurisdiction&procedure-id="
				+ procedureId;

		LOGGER.debug("Obtaining countries for procedure " + procedureId);

		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();

			Document doc = builder.parse(queryUrl);
			NodeList adminUnitLevel1Elements = doc.getElementsByTagName("oots:AdminUnitLevel1");

			// Iterate through the oots:AdminUnitLevel1 elements
			Set<String> countryCodes = new HashSet<String>();
			for (int i = 0; i < adminUnitLevel1Elements.getLength(); i++) {
				Node adminUnitLevel1 = adminUnitLevel1Elements.item(i);
				String adminUnitLevel1Value = adminUnitLevel1.getTextContent();
				countryCodes.add(adminUnitLevel1Value);
			}

			return countryCodes.stream().sorted()
					.map(item -> new CountryCode(item, countryCodeMap.getOrDefault(item, item)))
					.collect(Collectors.toList());

		} catch (ParserConfigurationException | SAXException | IOException e) {
			e.printStackTrace();
			return Collections.emptyList();
		}
	}

	@ApiOperation(value = "Vyhľadať zoznam typov procedúr", notes = "Získa zoznam procedúr pre konkrétnu krajinu.")
	@GetMapping("/lookup/procedureTypes/{countryCode}")
	public ProcedureTypesResponse lookupProcedureTypes(@PathVariable String countryCode) {
		String queryUrl = commonservicesUrl
				+ "/query/eb/rest/search?queryId=urn:fdc:oots:eb:ebxml-regrep:queries:requirements-by-procedure-and-jurisdiction&country-code="
				+ countryCode;

		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse(queryUrl);

			NodeList requirementElements = doc.getElementsByTagName("oots:ReferenceFramework");

			List<String> procedureIdentifiers = new ArrayList<String>();
			List<ProcedureType> requirements = new ArrayList<>();

			// Iterate through the requirement elements
			for (int i = 0; i < requirementElements.getLength(); i++) {
				Node requirementNode = requirementElements.item(i);

				if (requirementNode.getNodeType() == Node.ELEMENT_NODE) {
					Element requirementElement = (Element) requirementNode;


					String identifier = requirementElement.getElementsByTagName("oots:RelatedTo").item(0)
							.getTextContent().trim();
					String name = requirementElement.getElementsByTagName("oots:Title").item(0).getTextContent().trim();

					requirements.add(new ProcedureType(identifier, name));
				}
			}

			try {
				// You can return the list of RequirementInfo objects
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
			return new ProcedureTypesResponse(
					/* translateProcedureTypes(procedureIdentifiers, countryCode) */ requirements.stream().distinct()
							.collect(Collectors.toList()));

		} catch (ParserConfigurationException | SAXException | IOException e) {
			// Handle exceptions
			e.printStackTrace();
			return new ProcedureTypesResponse();
		}
	}

	private List<ProcedureType> translateProcedureTypes(List<String> someIdentifiers, String aLanguageCode) {
		List<ProcedureType> procedureTypes = new ArrayList<>();

		try {
			// URL of the XML file
			String url = "https://code.europa.eu/oots/tdd/tdd_chapters/-/raw/master/OOTS-EDM/codelists/OOTS/Procedures-CodeList.gc";

			// Open connection to the URL and get the input stream
			InputStream inputStream = new URL(url).openStream();

			// Create a DocumentBuilderFactory and DocumentBuilder to parse XML
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();

			// Parse the XML from the input stream
			Document doc = builder.parse(inputStream);

			// Close the input stream
			inputStream.close();

			// Get all Row elements from SimpleCodeList
			NodeList rows = doc.getElementsByTagName("Row");

			// Loop through each Row to find matching identifiers and country code
			for (int i = 0; i < rows.getLength(); i++) {
				Element row = (Element) rows.item(i);
				NodeList values = row.getElementsByTagName("Value");

				String code = "";
				String description = "";

				for (int j = 0; j < values.getLength(); j++) {
					Element value = (Element) values.item(j);
					String columnRef = value.getAttribute("ColumnRef");

					if (columnRef.equals("code")) {
						code = value.getElementsByTagName("SimpleValue").item(0).getTextContent();
					} else if (columnRef.startsWith("name-") && columnRef.substring(5).equals(aLanguageCode)) {
						description = value.getElementsByTagName("SimpleValue").item(0).getTextContent();
					}
				}

				// If the code matches the given country code and a description is found, add to
				// the list
				if (someIdentifiers.contains(code) && !description.isEmpty()) {
					procedureTypes.add(new ProcedureType(code, description));
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return procedureTypes;
	}



	@ApiOperation(value = "Vyhľadať požiadavky", notes = "Získa zoznam požiadaviek pre konkrétnu krajinu a identifikátor procedúry.")
	@GetMapping("/lookup/requirements/{countryCode}/{procedureId}")
	public RequirementsResponse lookupRequirements(@PathVariable String countryCode, @PathVariable String procedureId) {
		String queryUrl = commonservicesUrl
				+ "/query/eb/rest/search?queryId=urn:fdc:oots:eb:ebxml-regrep:queries:requirements-by-procedure-and-jurisdiction&country-code="
				+ countryCode + "&procedure-id=" + procedureId;

		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse(queryUrl);

			// Get the NodeList of oots:Requirement elements
			NodeList requirementElements = doc.getElementsByTagName("oots:Requirement");

			List<Requirement> requirements = new ArrayList<>();

			for (int i = 0; i < requirementElements.getLength(); i++) {
				Node requirementNode = requirementElements.item(i);

				if (requirementNode.getNodeType() == Node.ELEMENT_NODE) {
					Element requirementElement = (Element) requirementNode;

					String identifier = requirementElement.getElementsByTagName("oots:Identifier").item(0)
							.getTextContent().trim();
					String name = requirementElement.getElementsByTagName("oots:Name").item(0).getTextContent().trim();

					requirements.add(new Requirement(identifier, name));
				}
			}

			return new RequirementsResponse(requirements);

		} catch (ParserConfigurationException | SAXException | IOException e) {
			e.printStackTrace();
			return new RequirementsResponse();
		}

	}

	@ApiOperation(value = "Vyhľadať zoznam typov dôkazov", notes = "Získa zoznam typov dôkazov pre konkrétnu krajinu a identifikátor požiadavky.")
	@GetMapping("/lookup/evidenceTypes/{countryCode}")
	public EvidenceTypesResponse lookupEvidenceTypes(@PathVariable String countryCode,
			@RequestParam("requirementId") String requirementId) {
		String queryUrl = commonservicesUrl
				+ "/query/eb/rest/search?queryId=urn:fdc:oots:eb:ebxml-regrep:queries:evidence-types-by-requirement-and-jurisdiction&country-code="
				+ countryCode + "&requirement-id=" + requirementId;

		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse(queryUrl);

			NodeList evidenceTypeElements = doc.getElementsByTagName("oots:EvidenceType");

			List<EvidenceType> evidenceTypes = new ArrayList<>();

			for (int i = 0; i < evidenceTypeElements.getLength(); i++) {
				Node evidenceTypeNode = evidenceTypeElements.item(i);

				if (evidenceTypeNode.getNodeType() == Node.ELEMENT_NODE) {
					Element evidenceTypeElement = (Element) evidenceTypeNode;

					String identifier = evidenceTypeElement.getElementsByTagName("oots:EvidenceTypeClassification")
							.item(0).getTextContent().trim();
					String name = evidenceTypeElement.getElementsByTagName("oots:Title").item(0).getTextContent()
							.trim();

					evidenceTypes.add(new EvidenceType(identifier, name));
				}
			}
			return new EvidenceTypesResponse(evidenceTypes);

		} catch (ParserConfigurationException | SAXException | IOException e) {
			e.printStackTrace();
			return new EvidenceTypesResponse();
		}
	}
}