package sk.mirri.ootspoc.backend.client;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import sk.mirri.ootspoc.mapdb.MessageIdDatabase;

@Configuration
public class BackendClientServiceConfiguration {

	@Value("${domibus.backend.url}")
	private String wsURL;

	@Value("${db.filepath}")
	private String databasePath;

	@Bean
	public MessageIdDatabase mapDBComponent() throws MalformedURLException {
		return new MessageIdDatabase(databasePath);
	}

	@Bean
	public BackendClientService backendClient(MessageIdDatabase db) throws MalformedURLException {
		final URL url = URI.create(wsURL).toURL();
		return new BackendClientService(url, db);
	}

}
