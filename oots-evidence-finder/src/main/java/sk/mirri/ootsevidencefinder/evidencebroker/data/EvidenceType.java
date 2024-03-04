package sk.mirri.ootsevidencefinder.evidencebroker.data;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.Objects;

@Schema(description = "Typ dôkazu")
public class EvidenceType {
    @Schema(description = "Identifikátor typu dôkazu", example = "https://sr.oots.tech.ec.europa.eu/evidencetypeclassifications/EU/b6a49e54-8b3c-4688-acad-380440dc5962")
    private String id;

    @Schema(description = "Popis typu dôkazu", example = "EU-Wide Diploma/Bachelor's Degree")
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EvidenceType that = (EvidenceType) o;
        return Objects.equals(id, that.id) && Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, description);
    }
}