package com.rabobank.feign.client;

import com.rabobank.feign.model.Report;
import org.springframework.web.bind.annotation.GetMapping;

@org.springframework.cloud.openfeign.FeignClient(url = "${ext.base.url}/", name="Report-Client-1")
public interface CustomFeignClient {
    @GetMapping("${ext.get.records.uri}")
    Report getRecords();
}
