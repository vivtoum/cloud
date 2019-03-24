package com.kwdz;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
class TestController {

    @Value("${spring.application.name}")
    private String projectName;

    @Value("${server.port}")
    private String port;

    @RequestMapping("/from")
    public String from() {
        return this.projectName + ":" + this.port;
    }

}