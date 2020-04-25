package com.rabobank.feign.controller;

import com.rabobank.feign.model.Report;
import com.rabobank.feign.service.TransactionsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransactionsReportController {

    private final TransactionsService transactionsService;

    public TransactionsReportController(TransactionsService transactionsService) {
        this.transactionsService = transactionsService;
    }

    @GetMapping(value="/report", produces= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Report> getReport() {
        return transactionsService.getFailedRecords()
                .map(result -> new ResponseEntity<>(result, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NO_CONTENT));
    }
}
