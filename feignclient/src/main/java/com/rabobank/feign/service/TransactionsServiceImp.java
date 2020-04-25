package com.rabobank.feign.service;


import com.rabobank.feign.client.CustomFeignClient;
import com.rabobank.feign.model.Report;
import com.rabobank.feign.model.ReportEntry;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;


@Service
public class TransactionsServiceImp implements TransactionsService {
    CustomFeignClient customFeignClient;

    public TransactionsServiceImp(final CustomFeignClient customFeignClient) {
        this.customFeignClient = customFeignClient;
    }

    @Override
    public Optional<Report> getFailedRecords() {
        final Report report = new Report();
        try {
            final List<ReportEntry> entries = customFeignClient.getRecords().getEntries().stream()
                    .filter(distinctByKey(ReportEntry::getReference))
                    .filter(this::checkBalance)
                    .collect(Collectors.toList());
            report.setEntries(entries);
            return Optional.of(report);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public void setCustomFeignClient(final CustomFeignClient customFeignClient) {
        this.customFeignClient = customFeignClient;
    }

    private boolean checkBalance(final ReportEntry p) {
        return Double.parseDouble(p.getStartBalance()) +
                Double.parseDouble(p.getMutation()) !=
                Double.parseDouble(p.getEndBalance());
    }

    private <T> Predicate<? super ReportEntry> distinctByKey(final Function<ReportEntry, T> keyExtractor) {
        final Set<Object> seen = ConcurrentHashMap.newKeySet();
        return t -> seen.add(keyExtractor.apply(t));
    }
}
