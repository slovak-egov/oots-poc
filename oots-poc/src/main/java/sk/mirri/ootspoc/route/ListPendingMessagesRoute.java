package sk.mirri.ootspoc.route;

import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import sk.mirri.ootspoc.backend.client.BackendClientService;

@Component
public class ListPendingMessagesRoute extends RouteBuilder {

	@Autowired
	private BackendClientService client;

	@Override
	public void configure() throws Exception {

		// @formatter:off
		from("timer://myTimer?period=10000")
			.routeId("myRoute")
			.process(this::getPendingMessages)
			.to("log:messagesList")
			.split(body())
	            	.to("direct:retrieveMessage")
	        .end();

//		from("direct:getStatus")
//			.routeId("getStatusRoute").process(new Processor() {
//				@Override
//				public void process(Exchange exchange) throws Exception {
//					String uid = exchange.getIn().getBody(String.class);
//					exchange.getIn().setBody(wsClient.getStatus(uid));
//				}
//			})
//		.to("log:status");
		// @formatter:on

	}

	public void getPendingMessages(Exchange exchange) {
		exchange.getIn().setBody(client.getFilteredPendingMessages());
	}

}