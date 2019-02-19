package com.kwdz.eureka.feign.api;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("eureka-provider")
public interface DcClient {

    @GetMapping("/")
    String consumer();

}
