package com.kwdz.consumer1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@EnableEurekaClient
@EnableFeignClients //开启spring cloud feign的支持
@SpringBootApplication
public class Consumer1Application {

    public static void main(String[] args) {
        SpringApplication.run(Consumer1Application.class, args);
    }

}
