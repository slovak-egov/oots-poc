package sk.mirri.ootsevidencefinder.evidencebroker.data;

import java.util.Collections;
import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Response containing a list of requirements")
public class RequirementsResponse {

	@ApiModelProperty(value = "List of requirements")
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