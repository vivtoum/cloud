package com.kwdz.consumer1.controller;

import com.kwdz.consumer1.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class HelloController {
    @Autowired
    HelloService helloService;

    @GetMapping("/feign/{userid}")
    public String helloCustomer(@PathVariable("userid") String userid) {
        return helloService.getName(userid);
    }

}
