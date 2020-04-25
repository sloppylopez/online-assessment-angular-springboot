package com.rabobank.server.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Record {
    private String reference;
    private String mutation;
    private String endBalance;
    private String description;
    private String accountNumber;
    private String startBalance;

    @Override
    public String toString() {
        return "Record{" +
                "reference='" + reference + '\'' +
                ", mutation='" + mutation + '\'' +
                ", endBalance='" + endBalance + '\'' +
                ", description='" + description + '\'' +
                ", accountNumber='" + accountNumber + '\'' +
                ", startBalance='" + startBalance + '\'' +
                '}';
    }
}
