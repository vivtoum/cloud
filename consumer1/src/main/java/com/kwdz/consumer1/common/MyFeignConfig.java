package com.kwdz.consumer1.common;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyFeignConfig {

    /**
     * feign打印日志等级
     *
     * @return 失败
     */
    @Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }
}