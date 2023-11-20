package sk.mirri.ootspoc.route.evidence.type;

import org.springframework.stereotype.Component;

@Component
public class DiplomaBachelorEvidenceTypeRoute extends AbstractEvidenceTypeRoute {

	@Override
	public void configure() throws Exception {

		// toto posle dummy odpoved na poziadavku na dokaz o studiu

		// @formatter:off
		from("direct://https://sr.oots.tech.europa.eu/evidencetypeclassifications/EU/b6a49e54-8b3c-4688-acad-380440dc5962")
		.to("log:payloadToProcess")
		.choice()
        .when(header("testCase").isEqualTo("TC01"))
            .process(this::sendEvidenceResponse)
        .when(header("testCase").isEqualTo("TC02"))
            .process(this::sendEmptyEvidenceResponse)
        .otherwise()
            .to("log:unprocessed")
    .end();
		// @formatter:on

	}

}