package sk.mirri.ootspoc.route;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class QueryResponseMessageRoute extends RouteBuilder {

	@Override
	public void configure() throws Exception {

		// toto len zaloguje spravu - je to odpoved na ziadost o dokaz

		// @formatter:off		
		from("direct:queryResponseMessage")
			.routeId("queryResponseMessageRoute")
			.to("log:wholeMessage");
		// @formatter:on

	}

}