package com.rabobank.feign.model;

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
public class Report {
    @JacksonXmlProperty(localName = "Record")
    @JacksonXmlElementWrapper(useWrapping = false)
    private List<ReportEntry> entries = new ArrayList<>();

    @Override
    public String toString() {
        return "Report{" +
                "entries=" + entries +
                '}';
    }
}
