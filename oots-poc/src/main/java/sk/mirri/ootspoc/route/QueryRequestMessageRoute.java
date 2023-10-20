package sk.mirri.ootspoc.route;

import java.util.List;

import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

import sk.mirri.ootspoc.data.EvidenceMessage;
import sk.mirri.ootspoc.data.EvidenceRequestPayload;

@Component
public class QueryRequestMessageRoute extends RouteBuilder {

	@Override
	public void configure() throws Exception {

		// toto by malo vytiahnut payloady a kazdy poslat na
		// spracovanie dalej, ulozit nejake correlationId a dalsie data zo spravy aby sa
		// dali pospajat dokopy

		// @formatter:off		
		from("direct:queryRequestMessage")
			.routeId("queryRequestMessageRoute")
			.to("log:wholeRequestMessage")
			.process(this::extractPayloads)
			.split().body()
				.to("direct:processPayload")
			.end();
		// @formatter:on

	}

	public void extractPayloads(Exchange exchange) throws Exception {
		EvidenceMessage message = exchange.getIn().getBody(EvidenceMessage.class);
		List<EvidenceRequestPayload> payloads = message.extractPayloads();
		exchange.getIn().setBody(payloads);
	}
}