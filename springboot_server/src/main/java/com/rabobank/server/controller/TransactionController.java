package com.rabobank.server.controller;

import com.rabobank.server.model.Transactions;
import com.rabobank.server.service.TransactionsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransactionController {

    private final TransactionsService transactionsService;

    public TransactionController(TransactionsService transactionsService) {
        this.transactionsService = transactionsService;
    }

    @GetMapping(value="/records", produces= MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<Transactions> getAllRecords() {
        return transactionsService.findAllRecords()
                .map(result -> new ResponseEntity<>(result, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NO_CONTENT));
    }
}
