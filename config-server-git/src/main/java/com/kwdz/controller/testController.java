package com.kwdz.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @version 0.0.1
 * @author: huyt
 * @date: 2019/4/1 20:48
 */
@RestController
@Api("測試")
public class testController {

    @Value("${spring.application.name}")
    private String name;

    @Value("${server.port}")
    private String port;

    @ApiOperation("swagger2 测试类")
    @GetMapping("/")
    public String index() {
        return this.name + ":" + this.port;
    }
}
