package com.kwdz;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class client1 {

    public static void main(String[] args) {
        new SpringApplicationBuilder(client1.class).web(true).run(args);
    }

}
