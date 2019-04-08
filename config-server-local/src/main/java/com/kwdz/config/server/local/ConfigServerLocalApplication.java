package com.kwdz.config.server.local;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableDiscoveryClient
@EnableConfigServer
@SpringBootApplication
public class ConfigServerLocalApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConfigServerLocalApplication.class, args);
    }

}
