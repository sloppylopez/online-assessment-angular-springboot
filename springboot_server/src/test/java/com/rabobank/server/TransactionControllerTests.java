package com.rabobank.server;

import com.rabobank.server.controller.TransactionController;
import com.rabobank.server.model.Transactions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Objects;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class TransactionControllerTests {
    @Autowired
    TransactionController transactionsController;

    @Autowired
    private Transactions mockedTransactions;

    @Test
    public void shouldGetAllUniqueFailedRecords() {
        final ResponseEntity<Transactions> transactions = transactionsController.getAllRecords();

        assertThat(transactions.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(Objects.requireNonNull(transactions.getBody()).getRecords()).hasSize(10);

        for (int i=0; i<mockedTransactions.getRecords().size(); i++) {
            assertThat(transactions.getBody().getRecords().get(i)).isEqualToComparingFieldByField(mockedTransactions.getRecords().get(i));
        }
    }
}
