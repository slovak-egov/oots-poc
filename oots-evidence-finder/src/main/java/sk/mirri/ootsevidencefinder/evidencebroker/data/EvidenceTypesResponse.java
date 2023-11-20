package sk.mirri.ootsevidencefinder.evidencebroker.data;

import java.util.Collections;
import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Response containing a list of evidence types")
public class EvidenceTypesResponse {

	@ApiModelProperty(value = "List of evidence types")
	private List<EvidenceType> evidenceTypes;

	public EvidenceTypesResponse() {
		this.evidenceTypes = Collections.emptyList();
	}

	public EvidenceTypesResponse(List<EvidenceType> requirements) {
		this.evidenceTypes = requirements;
	}

	public List<EvidenceType> getEvidenceTypes() {
		return evidenceTypes;
	}
}