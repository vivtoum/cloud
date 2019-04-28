package com.kwdz.eureka.zuul;

import com.kwdz.eureka.zuul.filter.AccessFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableZuulProxy //开启网关Zuul
@EnableEurekaClient
@EnableSwagger2
@EnableOAuth2Sso
@SpringBootApplication
public class EurekaZuulApplication extends WebSecurityConfigurerAdapter {

    public static void main(String[] args) {
        SpringApplication.run(EurekaZuulApplication.class, args);
    }

    /**
     * 资源过滤器
     *
     * @return 资源过滤器
     */
    @Bean
    public AccessFilter accessFilter() {
        return new AccessFilter();
    }
}
