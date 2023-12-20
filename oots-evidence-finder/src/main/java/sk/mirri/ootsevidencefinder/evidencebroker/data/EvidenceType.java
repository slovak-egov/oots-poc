package sk.mirri.ootsevidencefinder.evidencebroker.data;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Evidence type")
public class EvidenceType {
	@ApiModelProperty(value = "Evidence type ID", example = "1")
	private String id;

	@ApiModelProperty(value = "Evidence Type Description", example = "Description of Evidence type 1")
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