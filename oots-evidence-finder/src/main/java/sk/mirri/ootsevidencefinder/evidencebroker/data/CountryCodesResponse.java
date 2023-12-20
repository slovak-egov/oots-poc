package sk.mirri.ootsevidencefinder.evidencebroker.data;

import java.util.Collections;
import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Response containing a list of country codes")
public class CountryCodesResponse {

	@ApiModelProperty(value = "List of country codes", example = "[\"SK\", \"CZ\", \"AT\"]")
	private List<CountryCode> countryCodes;

	public CountryCodesResponse() {
		this.countryCodes = Collections.emptyList();
	}

	public CountryCodesResponse(List<CountryCode> countryCodes) {
		this.countryCodes = countryCodes;
	}

	public List<CountryCode> getCountryCodes() {
		return countryCodes;
	}
}
