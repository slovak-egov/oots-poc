package sk.mirri.ootsevidencefinder.evidencebroker.data;

import java.util.Collections;
import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Odpoveď so zoznamom poskytovateľov dôkazov")
public class EvidenceProvidersResponse {

	@ApiModelProperty(value = "Zoznam poskytovateľov dôkazov", example = "{\r\n" + "  \"evidenceProviders\": [\r\n"
			+ "    {\r\n" + "      \"id\": \"sk_test_ap\",\r\n"
			+ "      \"description\": \"SK Ministry of the Projectathon\"\r\n" + "    }\r\n" + "  ]\r\n" + "}")
	private List<EvidenceProvider> evidenceProviders;

	public EvidenceProvidersResponse() {
		this.evidenceProviders = Collections.emptyList();
	}

	public EvidenceProvidersResponse(List<EvidenceProvider> providers) {
		this.evidenceProviders = providers;
	}

	public List<EvidenceProvider> getEvidenceProviders() {
		return evidenceProviders;
	}
}