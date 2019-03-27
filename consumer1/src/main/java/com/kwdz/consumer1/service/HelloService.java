package com.kwdz.consumer1.service;

import com.kwdz.consumer1.common.MyFeignConfig;
import com.kwdz.consumer1.fallback.HelloServiceFallback;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 用于通知Feign组件对该接口进行代理(不需要编写接口实现)， client1 代理的具体服务
 *
 * @author huyt
 */
@FeignClient(value = "client1", fallback = HelloServiceFallback.class, configuration = MyFeignConfig.class)
public interface HelloService {

    /**
     * 对应具体服务中的接口地址（具体服务controller 层的暴露接口）可以指定具体的get/post
     *
     * @param userid 用戶id
     * @return null
     * @deprecated 对应具体服务中的接口地址（具体服务controller 层的暴露接口）可以指定具体的get/post
     */
    @GetMapping("/user/{userid}")
    String getName(@PathVariable(value = "userid") String userid);
}