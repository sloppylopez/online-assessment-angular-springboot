package com.rabobank.feign.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReportEntry {
    private String reference;
    private String description;
    private String mutation;
    private String endBalance;
    private String startBalance;

    @Override
    public String toString() {
        return "Entry{" +
                "reference='" + reference + '\'' +
                ", description='" + description + '\'' +
                ", mutation='" + mutation + '\'' +
                ", endBalance='" + endBalance + '\'' +
                ", startBalance='" + startBalance + '\'' +
                '}';
    }
}
