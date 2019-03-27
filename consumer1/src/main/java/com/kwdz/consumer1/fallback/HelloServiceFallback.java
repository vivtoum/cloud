package com.kwdz.consumer1.fallback;

import com.kwdz.consumer1.service.HelloService;
import org.springframework.stereotype.Component;

@Component
public class HelloServiceFallback implements HelloService {

    @Override
    public String getName(String userid) {
        return "request error";
    }
}