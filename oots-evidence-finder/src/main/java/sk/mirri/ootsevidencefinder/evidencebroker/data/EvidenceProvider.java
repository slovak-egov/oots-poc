package sk.mirri.ootsevidencefinder.evidencebroker.data;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Provider")
public class EvidenceProvider {
	@ApiModelProperty(value = "Provider ID", example = "1")
	private String id;

	@ApiModelProperty(value = "Provider Description", example = "Description of Requirement 1")
	private String description;

	public EvidenceProvider(String id, String description) {
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