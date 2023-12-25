package sk.mirri.ootsevidencefinder.evidencebroker.data;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Požiadavka")
public class Requirement {
	@ApiModelProperty(value = "Identifikátor požiadavky", example = "https://sr.oots.tech.ec.europa.eu/requirements/f8a6a284-34e9-42c7-9733-63b5c4f4aa42")
	private String id;

	@ApiModelProperty(value = "Popis požiadavky", example = "Proof of tertiary education diploma/certificate/degree")
	private String description;

	public Requirement(String id, String description) {
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