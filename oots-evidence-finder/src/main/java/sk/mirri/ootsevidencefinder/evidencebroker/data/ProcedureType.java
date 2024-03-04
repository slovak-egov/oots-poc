package sk.mirri.ootsevidencefinder.evidencebroker.data;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.Objects;

@Schema(description = "Typ procedúry")
public class ProcedureType {
    @Schema(description = "Identifikátor typu procedúry", example = "T1")
    private String id;

    @Schema(description = "Popis typu procedúry", example = "Applying for a tertiary education study financing, such as study grants and loans from a public body or institution")
    private String description;

    public ProcedureType(String id, String description) {
        this.id = id;
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public int hashCode() {
        return Objects.hash(description, id);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!(obj instanceof ProcedureType))
            return false;
        ProcedureType other = (ProcedureType) obj;
        return Objects.equals(description, other.description) && Objects.equals(id, other.id);
    }
}