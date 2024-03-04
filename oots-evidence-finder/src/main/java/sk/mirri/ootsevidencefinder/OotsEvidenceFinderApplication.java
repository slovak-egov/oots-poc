package sk.mirri.ootsevidencefinder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class OotsEvidenceFinderApplication {
    @Bean
    public Map<String, String> countryCodeMap() {
        Map<String, String> countryCodeMap = new HashMap<String, String>();

        try {
            String url = "https://code.europa.eu/oots/tdd/tdd_chapters/-/raw/master/OOTS-EDM/codelists/OOTS/CountryIdentificationCode-CodeList.gc";
            InputStream inputStream = new URL(url).openStream();
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(inputStream);
            inputStream.close();
            NodeList rows = doc.getElementsByTagName("Row");
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
