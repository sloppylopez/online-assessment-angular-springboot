package com.rabobank.feign;

import com.rabobank.feign.client.CustomFeignClient;
import com.rabobank.feign.controller.TransactionsReportController;
import com.rabobank.feign.model.Report;
import com.rabobank.feign.service.TransactionsService;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Objects;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class FeignClientApplicationTest {
    @Qualifier("getMockedTransactions")
    @Autowired
    private Report mockedReport;
    @Qualifier("getMockedTransactionsWithDuplicates")
    @Autowired
    private Report mockedReportWithDuplicate;
    @Autowired
    private TransactionsService transactionsService;
    @Autowired
    private TransactionsReportController transactionsReportController;
    @MockBean
    private CustomFeignClient customFeignClient;

    @BeforeEach
    public void setup() {
        RestAssuredMockMvc.standaloneSetup(transactionsReportController);
        transactionsService.setCustomFeignClient(customFeignClient);
        Report report = mock(Report.class);
        Mockito.when(customFeignClient.getRecords()).thenReturn(report);
        Mockito.when(report.getEntries()).thenReturn(mockedReportWithDuplicate.getEntries());
    }

    @Test
    void shouldGetReportWithUniqueFailedTransactionRecords() {
        final Report report = transactionsService.getFailedRecords().orElse(null);
        assertThat(Objects.requireNonNull(report).getEntries()).hasSize(4);
        for (int i = 0; i < mockedReport.getEntries().size(); i++) {
            assertThat(report.getEntries().get(i))
                    .isEqualToComparingFieldByField(mockedReport.getEntries().get(i));
        }
    }
}
