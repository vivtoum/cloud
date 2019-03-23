package com.kwdz;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

//@EnableDiscoveryClient
@SpringBootApplication
public class ConfigClient {

    public static void main(String[] args) {
        new SpringApplicationBuilder(ConfigClient.class).web(true).run(args);
    }

}
