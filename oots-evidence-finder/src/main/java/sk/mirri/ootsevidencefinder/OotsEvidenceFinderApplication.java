package sk.mirri.ootsevidencefinder;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

@SpringBootApplication
public class OotsEvidenceFinderApplication {

	@Bean
	public Map<String, String> countryCodeMap() {
		// Initialize the map with country codes and names
		Map<String, String> countryCodeMap = new HashMap<String, String>();

		try {
			// URL of the XML file
			String url = "https://code.europa.eu/oots/tdd/tdd_chapters/-/raw/master/OOTS-EDM/codelists/OOTS/CountryIdentificationCode-CodeList.gc";

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

			// Loop through each Row to extract country code and name
			for (int i = 0; i < rows.getLength(); i++) {
				Element row = (Element) rows.item(i);
				NodeList values = row.getElementsByTagName("Value");

				String countryCode = "";
				String countryName = "";

				for (int j = 0; j < values.getLength(); j++) {
					Element value = (Element) values.item(j);
					String columnRef = value.getAttribute("ColumnRef");

					switch (columnRef) {
					case "code":
						countryCode = value.getElementsByTagName("SimpleValue").item(0).getTextContent();
						break;
					case "name":
						countryName = value.getElementsByTagName("SimpleValue").item(0).getTextContent();
						break;
					}
					countryCodeMap.put(countryCode, countryName);
				}

				// Here, countryCode and countryName will have the values for each country.
				System.out.println("Country Code: " + countryCode + ", Country Name: " + countryName);
			}

		} catch (IOException | javax.xml.parsers.ParserConfigurationException | org.xml.sax.SAXException e) {
			e.printStackTrace();
		}

		return countryCodeMap;
	}

	public static void main(String[] args) {
		SpringApplication.run(OotsEvidenceFinderApplication.class, args);
	}

}
