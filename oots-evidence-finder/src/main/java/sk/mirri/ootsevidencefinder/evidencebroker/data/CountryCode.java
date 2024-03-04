package sk.mirri.ootsevidencefinder.evidencebroker.data;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.Objects;

@Schema(description = "Skratka krajiny a názov")
public class CountryCode {
    @Schema(description = "Skratka", example = "SK")
    private String countryCode;

    @Schema(description = "Názov krajiny", example = "Slovakia")
    private String countryName;

    public CountryCode(String id, String description) {
        this.countryCode = id;
        this.countryName = description;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public String getCountryName() {
        return countryName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CountryCode that = (CountryCode) o;
        return Objects.equals(countryCode, that.countryCode) && Objects.equals(countryName, that.countryName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(countryCode, countryName);
    }
}