package com.rabobank.server;

import com.rabobank.server.model.Transactions;
import com.rabobank.server.service.TransactionsService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Objects;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class TransactionServiceTests {
    @Autowired
    private TransactionsService transactionsService;

    @Autowired
    private Transactions mockedTransactions;

    @Test
    public void shouldGetAllUniqueFailedRecords() {
        final Optional<Transactions> optTransactions = transactionsService.findAllRecords();
        final Transactions transactions = optTransactions.orElse(null);
        assertThat(Objects.requireNonNull(transactions).getRecords()).hasSize(10);

        for (int i=0; i<mockedTransactions.getRecords().size(); i++) {
            assertThat(transactions.getRecords().get(i)).isEqualToComparingFieldByField(mockedTransactions.getRecords().get(i));
        }
    }
}
