package com.kwdz;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableDiscoveryClient
@EnableConfigServer
@EnableSwagger2
@SpringBootApplication
public class ConfigServerGit {

    public static void main(String[] args) {
        new SpringApplicationBuilder(ConfigServerGit.class).web(true).run(args);
    }

}
