package sk.mirri.ootsevidencefinder.evidencebroker.data;

import java.util.Collections;
import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Response containing a list of procedure types")
public class ProcedureTypesResponse {

	@ApiModelProperty(value = "List of procedure types", example = "[\"T1\", \"T2\"]")
	private List<ProcedureType> procedureTypes;

	public ProcedureTypesResponse() {
		this.procedureTypes = Collections.emptyList();
	}

	public ProcedureTypesResponse(List<ProcedureType> procedureTypes) {
		this.procedureTypes = procedureTypes;
	}

	public List<ProcedureType> getProcedureTypes() {
		return procedureTypes;
	}
}
