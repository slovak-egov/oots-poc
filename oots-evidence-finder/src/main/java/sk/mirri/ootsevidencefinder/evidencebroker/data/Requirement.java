package sk.mirri.ootsevidencefinder.evidencebroker.data;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Požiadavka")
public class Requirement {
    @Schema(description = "Identifikátor požiadavky", example = "https://sr.oots.tech.ec.europa.eu/requirements/f8a6a284-34e9-42c7-9733-63b5c4f4aa42")
    private String id;

    @Schema(description = "Popis požiadavky", example = "Proof of tertiary education diploma/certificate/degree")
    private String description;

    public Requirement(String id, String description) {
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