package sk.mirri.ootsevidencefinder.evidencebroker.data;

import java.util.Collections;
import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Response containing a list of evidence providers")
public class EvidenceProvidersResponse {

	@ApiModelProperty(value = "List of evidence providers")
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