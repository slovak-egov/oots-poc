package sk.mirri.ootsevidencefinder.evidencebroker.data;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Skratka krajiny a názov")
public class CountryCode {
	@ApiModelProperty(value = "Skratka", example = "SK")
	private String countryCode;

	@ApiModelProperty(value = "Názov krajiny", example = "Slovakia")
	private String countryName;

	public CountryCode(String id, String description) {
		this.countryCode = id;
		this.countryName = description;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public String getCountryName() {
		return countryName;
	}
}