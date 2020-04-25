package com.rabobank.server.config;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.rabobank.server.model.Transactions;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UncheckedIOException;

import static java.nio.charset.StandardCharsets.UTF_8;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Value("classpath:data/records.xml")
    Resource resource;

    @Bean
    public Transactions getMockedTransactions() {
        final XmlMapper xmlMapper = new XmlMapper();
        try (Reader reader = new InputStreamReader(resource.getInputStream(), UTF_8)) {
            return xmlMapper.readValue(FileCopyUtils.copyToString(reader), Transactions.class);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }
}
