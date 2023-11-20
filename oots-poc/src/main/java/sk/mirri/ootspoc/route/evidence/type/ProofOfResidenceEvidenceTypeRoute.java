package sk.mirri.ootspoc.route.evidence.type;

import org.springframework.stereotype.Component;

@Component
public class ProofOfResidenceEvidenceTypeRoute extends AbstractEvidenceTypeRoute {

	@Override
	public void configure() throws Exception {

		// toto posle dummy odpoved na poziadavku na dokaz o studiu

		// @formatter:off
		from("direct://https://sr.oots.tech.ec.europa.eu/evidencetypeclassifications/EU/42d48a82-0bd7-4c59-af18-b0d21dc21e7f")
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