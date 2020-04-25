package com.rabobank.server.service;

import com.rabobank.server.model.Transactions;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class TransactionServiceImp implements TransactionsService {
    private final Transactions transactions;

    public TransactionServiceImp(final Transactions transactions) {
        this.transactions = transactions;
    }

    @Override
    public Optional<Transactions> findAllRecords() {
        return Optional.of(transactions);
    }
}
