package sk.mirri.ootsevidencefinder.evidencebroker.data;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Poskytovateľ dôkazu")
public class EvidenceProvider {
	@ApiModelProperty(value = "Identifikátor poskytovateľa", example = "sk_test_ap")
	private String id;

	@ApiModelProperty(value = "Popis poskytovateľa", example = "SK Ministry of the Projectathon")
	private String description;

	public EvidenceProvider(String id, String description) {
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