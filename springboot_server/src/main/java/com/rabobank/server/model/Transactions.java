package com.rabobank.server.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class Transactions {
    @JacksonXmlProperty(localName = "Record")
    @JacksonXmlElementWrapper(useWrapping = false)
    private List<Record> records = new ArrayList<>();

    @Override
    public String toString() {
        return "Transactions{" +
                "records=" + records +
                '}';
    }
}
