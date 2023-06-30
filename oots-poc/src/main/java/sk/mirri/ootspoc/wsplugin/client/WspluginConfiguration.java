package sk.mirri.ootspoc.wsplugin.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class WspluginConfiguration {

	@Value("${domibus.wsplugin.url}")
	private String wsURL;

	@Bean
	public Jaxb2Marshaller marshaller() {
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();

		// this package must match the package in the <generatePackage> specified in
		// pom.xml
		// String[] packagesToScan= {"sk.mirri.oots.projectatonbe.wsplugin.wsdl"};
//		marshaller.setPackagesToScan("wsplugin.domibus.eu");
		marshaller.setContextPath("wsplugin.domibus.eu");
		return marshaller;
	}

	@Bean
	public WSPluginServiceClient wSPluginServiceClient(Jaxb2Marshaller marshaller) {
		WSPluginServiceClient client = new WSPluginServiceClient();
		client.setDefaultUri(wsURL);
		client.setMarshaller(marshaller);
		client.setUnmarshaller(marshaller);
		return client;
	}

}
