package sk.mirri.ootsevidencefinder.evidencebroker.data;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Tyz procedúry")
public class ProcedureType {
	@ApiModelProperty(value = "Identifikátor typu procedúry", example = "T1")
	private String id;

	@ApiModelProperty(value = "Popis typu procedúry", example = "Applying for a tertiary education study financing, such as study grants and loans from a public body or institution")
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