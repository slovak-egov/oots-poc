package sk.mirri.ootsevidencefinder.evidencebroker.data;

import java.util.Collections;
import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Odpoveď so zoznamom typov dôkazov")
public class EvidenceTypesResponse {

	@ApiModelProperty(value = "Zoznam typov dôkazov", example = "{\r\n" + "  \"evidenceTypes\": [\r\n" + "    {\r\n"
			+ "      \"id\": \"https://sr.oots.tech.ec.europa.eu/evidencetypeclassifications/EU/b6a49e54-8b3c-4688-acad-380440dc5962\",\r\n"
			+ "      \"description\": \"EU-Wide Diploma/Bachelor's Degree\"\r\n" + "    }\r\n" + "  ]\r\n" + "}")
	private List<EvidenceType> evidenceTypes;

	public EvidenceTypesResponse() {
		this.evidenceTypes = Collections.emptyList();
	}

	public EvidenceTypesResponse(List<EvidenceType> requirements) {
		this.evidenceTypes = requirements;
	}

	public List<EvidenceType> getEvidenceTypes() {
		return evidenceTypes;
	}
}