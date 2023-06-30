package sk.mirri.ootspoc.route;

import java.util.stream.Collectors;

import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import sk.mirri.ootspoc.wsplugin.client.WSPluginServiceClient;
import sk.mirri.ootspoc.wsplugin.regrep4.QueryRequest;
import wsplugin.domibus.eu.LargePayloadType;
import wsplugin.domibus.eu.RetrieveMessageResponse;

@Component
public class RetreiveMessageRoute extends RouteBuilder {

	@Autowired
	private WSPluginServiceClient wsClient;

	@Override
	public void configure() throws Exception {

		// toto by malo vytiahnut spravu, payloady, a kazdy poslat na
		// spracovanie dalej, ulozit nejake correlationId a dalsie data zo spravy aby sa
		// dali pospajat dokopy

		// @formatter:off
		from("direct:retreiveMessage")
			.routeId("retreiveMessageRoute")
			//odtial to uz musi byt perzistovane lebo po vycitani spravy sprava zmizne z domibusu
			.process(this::getMessage)
			.to("log:wholeMessage")
			.process(this::extractPayloads)
			.split().body()
				.setBody(simple("${body.content}")) 
				.process(this::setUuidHeader)
				.log("Headers: ${headers}")
				.to("direct:processPayload")
			.end();
		// @formatter:on

	}

	public void getMessage(Exchange exchange) throws Exception {
		String uid = exchange.getIn().getBody(String.class);
		RetrieveMessageResponse response = wsClient.retieveMessage(uid);
		exchange.getIn().setBody(response);
	}

	public void extractPayloads(Exchange exchange) throws Exception {
		RetrieveMessageResponse response = exchange.getIn().getBody(RetrieveMessageResponse.class);
		exchange.getIn()
				.setBody(response.getPayload().stream().map(LargePayloadType::getValue).collect(Collectors.toList()));
	}

	public void setUuidHeader(Exchange exchange) throws Exception {
		QueryRequest request = exchange.getIn().getBody(QueryRequest.class);
		// neviem co tu ma byt ako id s ktorym treba poslat dokaz naspat, asi skor
		// conversationId z headera z prvej spravy
		exchange.getIn().setHeader("UUID", request.getId());
	}

}