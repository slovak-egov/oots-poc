package sk.mirri.ootspoc.route;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import sk.mirri.ootspoc.wsplugin.client.WSPluginServiceClient;

@Component
public class ListPendingMessagesRoute extends RouteBuilder {

	@Autowired
	private WSPluginServiceClient wsClient;

	@Override
	public void configure() throws Exception {

		// @formatter:off
		from("timer://myTimer?period=5000")
			.routeId("myRoute")
			.process(this::getPendingMessages)
			.to("log:messagesList")
			.split(body())
//	    		.to("direct:getStatus")
//	    		.to("direct:getErrors")
				.to("direct:retreiveMessage")
			.end();

		from("direct:getStatus")
			.routeId("getStatusRoute").process(new Processor() {
				@Override
				public void process(Exchange exchange) throws Exception {
					String uid = exchange.getIn().getBody(String.class);
					exchange.getIn().setBody(wsClient.getStatus(uid));
				}
			})
		.to("log:status");
		
		// TODO vyfiltrovat len tie spravy co su bez chyb, nefunguje
		from("direct:getErrors")
			.routeId("getErrorsRoute")
			.process(new Processor() {
				@Override
				public void process(Exchange exchange) throws Exception {
					String uid = exchange.getIn().getBody(String.class);
					exchange.getIn().setBody(wsClient.getMessageErrors(uid));
				}
			})
		.to("log:errors");
		// @formatter:on

	}

	public void getPendingMessages(Exchange exchange) {
		// TODO nahradit clienta za cxf endpoint
		exchange.getIn().setBody(wsClient.getPendingMessages().getMessageID());
	}

}