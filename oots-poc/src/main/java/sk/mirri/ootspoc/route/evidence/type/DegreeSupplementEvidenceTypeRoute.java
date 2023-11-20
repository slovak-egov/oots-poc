package sk.mirri.ootspoc.route.evidence.type;

import org.springframework.stereotype.Component;

@Component
public class DegreeSupplementEvidenceTypeRoute extends AbstractEvidenceTypeRoute {

	@Override
	public void configure() throws Exception {

		// toto posle dummy odpoved na poziadavku na dokaz o studiu

		// @formatter:off
		from("direct://https://sr.oots.tech.ec.europa.eu/evidencetypeclassifications/EU/d080dc98-46ae-4a00-a5f7-b54da000457a")
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