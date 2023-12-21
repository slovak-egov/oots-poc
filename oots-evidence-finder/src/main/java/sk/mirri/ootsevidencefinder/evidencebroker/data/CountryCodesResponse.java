package sk.mirri.ootsevidencefinder.evidencebroker.data;

import java.util.Collections;
import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Response containing a list of country codes")
public class CountryCodesResponse {

	@ApiModelProperty(value = "List of country codes", example = "{\r\n" + "  \"countryCodes\": [\r\n" + "    {\r\n"
			+ "      \"id\": \"AT\",\r\n" + "      \"description\": \"Austria\"\r\n" + "    },\r\n" + "    {\r\n"
			+ "      \"id\": \"BE\",\r\n" + "      \"description\": \"Belgium\"\r\n" + "    },\r\n" + "    {\r\n"
			+ "      \"id\": \"CY\",\r\n" + "      \"description\": \"Cyprus\"\r\n" + "    },\r\n" + "    {\r\n"
			+ "      \"id\": \"CZ\",\r\n" + "      \"description\": \"Czechia\"\r\n" + "    },\r\n" + "    {\r\n"
			+ "      \"id\": \"DE\",\r\n" + "      \"description\": \"Germany\"\r\n" + "    },\r\n" + "    {\r\n"
			+ "      \"id\": \"EC\",\r\n" + "      \"description\": \"Ecuador\"\r\n" + "    },\r\n" + "    {\r\n"
			+ "      \"id\": \"EE\",\r\n" + "      \"description\": \"Estonia\"\r\n" + "    },\r\n" + "    {\r\n"
			+ "      \"id\": \"EL\",\r\n" + "      \"description\": \"Greece\"\r\n" + "    },\r\n" + "    {\r\n"
			+ "      \"id\": \"ES\",\r\n" + "      \"description\": \"Spain\"\r\n" + "    },\r\n" + "    {\r\n"
			+ "      \"id\": \"FI\",\r\n" + "      \"description\": \"Finland\"\r\n" + "    },\r\n" + "    {\r\n"
			+ "      \"id\": \"FR\",\r\n" + "      \"description\": \"France\"\r\n" + "    },\r\n" + "    {\r\n"
			+ "      \"id\": \"HR\",\r\n" + "      \"description\": \"Croatia\"\r\n" + "    },\r\n" + "    {\r\n"
			+ "      \"id\": \"HU\",\r\n" + "      \"description\": \"Hungary\"\r\n" + "    },\r\n" + "    {\r\n"
			+ "      \"id\": \"IE\",\r\n" + "      \"description\": \"Ireland\"\r\n" + "    },\r\n" + "    {\r\n"
			+ "      \"id\": \"IT\",\r\n" + "      \"description\": \"Italy\"\r\n" + "    },\r\n" + "    {\r\n"
			+ "      \"id\": \"LT\",\r\n" + "      \"description\": \"Lithuania\"\r\n" + "    },\r\n" + "    {\r\n"
			+ "      \"id\": \"LU\",\r\n" + "      \"description\": \"Luxembourg\"\r\n" + "    },\r\n" + "    {\r\n"
			+ "      \"id\": \"LV\",\r\n" + "      \"description\": \"Latvia\"\r\n" + "    },\r\n" + "    {\r\n"
			+ "      \"id\": \"MT\",\r\n" + "      \"description\": \"Malta\"\r\n" + "    },\r\n" + "    {\r\n"
			+ "      \"id\": \"NL\",\r\n" + "      \"description\": \"Netherlands (the)\"\r\n" + "    },\r\n"
			+ "    {\r\n" + "      \"id\": \"PL\",\r\n" + "      \"description\": \"Poland\"\r\n" + "    },\r\n"
			+ "    {\r\n" + "      \"id\": \"PT\",\r\n" + "      \"description\": \"Portugal\"\r\n" + "    },\r\n"
			+ "    {\r\n" + "      \"id\": \"RO\",\r\n" + "      \"description\": \"Romania\"\r\n" + "    },\r\n"
			+ "    {\r\n" + "      \"id\": \"SE\",\r\n" + "      \"description\": \"Sweden\"\r\n" + "    },\r\n"
			+ "    {\r\n" + "      \"id\": \"SI\",\r\n" + "      \"description\": \"Slovenia\"\r\n" + "    },\r\n"
			+ "    {\r\n" + "      \"id\": \"SK\",\r\n" + "      \"description\": \"Slovakia\"\r\n" + "    }\r\n"
			+ "  ]\r\n" + "}")
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
