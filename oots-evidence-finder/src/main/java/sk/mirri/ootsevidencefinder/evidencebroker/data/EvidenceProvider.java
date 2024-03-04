package sk.mirri.ootsevidencefinder.evidencebroker.data;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Poskytovateľ dôkazu")
public class EvidenceProvider {
    @Schema(description = "Identifikátor poskytovateľa", example = "sk_test_ap")
    private String id;

    @Schema(description = "Popis poskytovateľa", example = "SK Ministry of the Projectathon")
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