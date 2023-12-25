package sk.mirri.ootsevidencefinder.evidencebroker.data;

import java.util.Collections;
import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Odpoveď so zoznamom požiadavok")
public class RequirementsResponse {

	@ApiModelProperty(value = "Zoznam požiadavok", example = "{\r\n" + "  \"requirements\": [\r\n" + "    {\r\n"
			+ "      \"id\": \"https://sr.oots.tech.ec.europa.eu/requirements/9196feb5-a88f-488d-8aad-7842cf64d1ac\",\r\n"
			+ "      \"description\": \"Proof of secondary education diploma/certificate\"\r\n" + "    },\r\n"
			+ "    {\r\n"
			+ "      \"id\": \"https://sr.oots.tech.ec.europa.eu/requirements/f8a6a284-34e9-42c7-9733-63b5c4f4aa42\",\r\n"
			+ "      \"description\": \"Proof of tertiary education diploma/certificate/degree\"\r\n" + "    }\r\n"
			+ "  ]\r\n" + "}")
	private List<Requirement> requirements;

	public RequirementsResponse() {
		this.requirements = Collections.emptyList();
	}

	public RequirementsResponse(List<Requirement> requirements) {
		this.requirements = requirements;
	}

	public List<Requirement> getRequirements() {
		return requirements;
	}
}