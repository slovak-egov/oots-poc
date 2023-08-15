package sk.mirri.ootspoc.route;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class ProcessPayloadRoute extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		// @formatter:off
		from("direct:processPayload")
		.to("log:payloadToProcess")
		.toD("direct:${body.getEvidenceClassification}");
		// @formatter:on

	}

}