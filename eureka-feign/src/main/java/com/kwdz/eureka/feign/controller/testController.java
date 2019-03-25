package com.kwdz.eureka.feign.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yt
 * @date 2019-03-25 14:50
 * @Version 1.0
 */
@RestController
@RefreshScope
public class testController {

    @Value("${spring.application.name}")
    private String projectName;

    @Value("${server.port}")
    private String port;

    @Value("${test}")
    private String test;

    @RequestMapping("/")
    public String from() {
        return this.projectName + ":" + this.port + "   and test:" + this.test;
    }

}
