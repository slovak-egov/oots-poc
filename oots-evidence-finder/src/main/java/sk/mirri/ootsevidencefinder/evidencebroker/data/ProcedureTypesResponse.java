package sk.mirri.ootsevidencefinder.evidencebroker.data;

import java.util.Collections;
import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Odpoveď so zoznamom typov procedúr")
public class ProcedureTypesResponse {

	@ApiModelProperty(value = "Zoznam typov procedúr", example = "{\r\n" + "  \"procedureTypes\": [\r\n" + "    {\r\n"
			+ "      \"id\": \"T1\",\r\n"
			+ "      \"description\": \"Applying for a tertiary education study financing, such as study grants and loans from a public body or institution\"\r\n"
			+ "    },\r\n" + "    {\r\n" + "      \"id\": \"V1\",\r\n"
			+ "      \"description\": \"Registering a change of address\"\r\n" + "    }\r\n" + "  ]\r\n" + "}")
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
