package sk.mirri.ootspoc.route;

import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import sk.mirri.ootspoc.backend.client.BackendClientService;
import sk.mirri.ootspoc.data.EvidenceMessage;

@Component
public class RetrieveMessageRoute extends RouteBuilder {

	@Autowired
	private BackendClientService client;

	@Override
	public void configure() throws Exception {

		// toto by malo vytiahnut spravu, payloady, a kazdy poslat na
		// spracovanie dalej, ulozit nejake correlationId a dalsie data zo spravy aby sa
		// dali pospajat dokopy

		// @formatter:off		
		from("direct:retrieveMessage")
			.routeId("retrieveMessageRoute")
			//odtial to uz musi byt perzistovane lebo po vycitani spravy sprava zmizne z domibusu
			.process(this::retrieveMessage)
			.choice()
		        .when(simple("${body.isEvidenceRequest}"))// TODO vyhodnotit ci som precital request alebo response
		            .to("direct:queryRequestMessage")
		        .otherwise()
		            .to("direct:queryResponseMessage");
		// @formatter:on

	}

	public void retrieveMessage(Exchange exchange) throws Exception {
		String messageId = exchange.getIn().getBody(String.class);
		EvidenceMessage message = client.retrieveMessage(messageId);
		exchange.getIn().setBody(message);
	}
}