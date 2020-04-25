package com.rabobank.server.service;

import com.rabobank.server.model.Transactions;

import java.util.Optional;

public interface TransactionsService {
    Optional<Transactions> findAllRecords();
}
