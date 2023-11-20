package sk.mirri.ootsevidencefinder.evidencebroker.data;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Requirement")
public class EvidenceType {
	@ApiModelProperty(value = "Requirement ID", example = "1")
	private String id;

	@ApiModelProperty(value = "Requirement Description", example = "Description of Requirement 1")
	private String description;

	public EvidenceType(String id, String description) {
		this.id = id;
		this.description = description;
	}

	public String getId() {
		return id;
	}

	public String getDescription() {
		return description;
	}
}