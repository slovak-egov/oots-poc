package sk.mirri.ootspoc.route;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JaxbDataFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import sk.mirri.ootspoc.wsplugin.client.WSPluginServiceClient;

@Component
public class ProcessPayloadRoute extends RouteBuilder {

	@Autowired
	private WSPluginServiceClient wsClient;

	@Override
	public void configure() throws Exception {

		// toto by malo spracovat payloady - rozdelit ich podla typu dokazu a poslat
		// dalej do routy ktora poskytuje samostatny typ dokazu uvedeny v <sdg:EvidenceTypeClassification>
		// na to vyrobit abstraktnu triedu ktora dokaze poskytnut typ dokazu, potom
		// vyrobit instancie pre jednotlive typy dokazov

		// @formatter:off
		from("direct:processPayload")
		    .to("log:payloadToProcess");
		// @formatter:on

	}

}