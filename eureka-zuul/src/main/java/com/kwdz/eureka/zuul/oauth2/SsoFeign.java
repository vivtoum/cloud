package com.kwdz.eureka.zuul.oauth2;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "sso-server", path = "/")
public interface SsoFeign {

    /**
     * 判断key是否存在
     */
    @RequestMapping("redis/hasKey/{key}")
    public Boolean hasKey(@PathVariable("key") String key);

}
