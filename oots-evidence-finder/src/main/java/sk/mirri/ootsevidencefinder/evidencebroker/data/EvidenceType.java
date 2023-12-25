package sk.mirri.ootsevidencefinder.evidencebroker.data;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Typ dôkazu")
public class EvidenceType {
	@ApiModelProperty(value = "Identifikátor typu dôkazu", example = "https://sr.oots.tech.ec.europa.eu/evidencetypeclassifications/EU/b6a49e54-8b3c-4688-acad-380440dc5962")
	private String id;

	@ApiModelProperty(value = "Popis typu dôkazu", example = "EU-Wide Diploma/Bachelor's Degree")
	private String description;

	public EvidenceType(String id, String description) {
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