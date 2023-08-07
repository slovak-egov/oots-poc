package sk.mirri.ootspoc.route;

import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import sk.mirri.ootspoc.backend.client.BackendClientService;
import sk.mirri.ootspoc.data.EvidenceRequestMessage;

@Component
public class RetreiveMessageRoute extends RouteBuilder {

	@Autowired
	private BackendClientService client;

	@Override
	public void configure() throws Exception {

		// toto by malo vytiahnut spravu, payloady, a kazdy poslat na
		// spracovanie dalej, ulozit nejake correlationId a dalsie data zo spravy aby sa
		// dali pospajat dokopy

		// @formatter:off		
		from("direct:retreiveMessage")
			.routeId("retreiveMessageRoute")
			//odtial to uz musi byt perzistovane lebo po vycitani spravy sprava zmizne z domibusu
			.process(this::retrieveMessage)
			.to("log:wholeMessage")
			.process(this::extractPayloads)
			.split().body()
				.to("direct:processPayload")
			.end();
		// @formatter:on

	}

	public void retrieveMessage(Exchange exchange) throws Exception {
		String messageId = exchange.getIn().getBody(String.class);
		EvidenceRequestMessage message = client.retrieveMessage(messageId);
		exchange.getIn().setBody(message);
	}

	public void extractPayloads(Exchange exchange) throws Exception {
		EvidenceRequestMessage message = exchange.getIn().getBody(EvidenceRequestMessage.class);
		exchange.getIn().setBody(message.extractPayloads());
	}
}