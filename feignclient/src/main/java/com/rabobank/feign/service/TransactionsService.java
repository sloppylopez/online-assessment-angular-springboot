package com.rabobank.feign.service;

import com.rabobank.feign.client.CustomFeignClient;
import com.rabobank.feign.model.Report;

import java.util.Optional;

public interface TransactionsService {
    Optional<Report> getFailedRecords();
    void setCustomFeignClient(final CustomFeignClient customFeignClient);
}
