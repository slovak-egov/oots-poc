package sk.mirri.ootsevidencefinder.evidencebroker.data;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Skratka krajiny a názov")
public class CountryCode {
	@ApiModelProperty(value = "Skratka", example = "SK")
	private String id;

	@ApiModelProperty(value = "Názov krajiny", example = "Slovakia")
	private String description;

	public CountryCode(String id, String description) {
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