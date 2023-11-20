package sk.mirri.ootsevidencefinder.evidencebroker.data;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Procedure type")
public class ProcedureType {
	@ApiModelProperty(value = "Proceture type identifier", example = "1")
	private String id;

	@ApiModelProperty(value = "Procedure type description", example = "Description of procedure type 1")
	private String description;

	public ProcedureType(String id, String description) {
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