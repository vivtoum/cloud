package com.kwdz.file.upload.fileserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import com.kwdz.file.upload.config.ApplicationConfig;

/**
 * @see ApplicationConfig 公用配置
 */
@EnableEurekaClient
@SpringBootApplication
public class FileUploadApplication {

    public static void main(String[] args) {
        SpringApplication.run(FileUploadApplication.class, args);
    }

}
