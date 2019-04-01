package com.kwdz;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@EnableDiscoveryClient
@SpringBootApplication
@RestController
@RefreshScope
public class ConfigClient {

    public static void main(String[] args) {
        new SpringApplicationBuilder(ConfigClient.class).web(true).run(args);
    }

    @Value("${spring.application.name}")
    private String projectName;

    @Value("${server.port}")
    private String port;

    @Value("${test}")
    private String test;

    @RequestMapping("/")
    public String from() {
        return this.projectName + ":" + this.port + "   and test:" + test;
    }

}
