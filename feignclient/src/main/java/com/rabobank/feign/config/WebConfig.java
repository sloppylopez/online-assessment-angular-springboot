package com.rabobank.feign.config;

import com.fasterxml.jackson.databind.json.JsonMapper;
import com.rabobank.feign.model.Report;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UncheckedIOException;

import static java.nio.charset.StandardCharsets.UTF_8;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    final ResourceLoader resourceLoader;

    @Value("classpath:data/mocked.report.response.json")
    Resource resource;

    @Value("classpath:data/mocked.report.response.with.duplicates.json")
    Resource resourceWithDuplicates;

    public WebConfig(final ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    @Bean
    public Report getMockedTransactions() {
        return getReportFromResource(resource);
    }

    @Bean
    public Report getMockedTransactionsWithDuplicates() {
        return getReportFromResource(resourceWithDuplicates);
    }

    private Report getReportFromResource(Resource resourceWithDuplicates) {
        final JsonMapper jsonMapper = new JsonMapper();
        try (Reader reader = new InputStreamReader(resourceWithDuplicates.getInputStream(), UTF_8)) {
            return jsonMapper.readValue(FileCopyUtils.copyToString(reader), Report.class);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }
}
