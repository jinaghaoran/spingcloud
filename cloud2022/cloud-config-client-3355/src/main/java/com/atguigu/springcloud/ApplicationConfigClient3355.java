package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * ApplicationConfigClient3355
 *
 * @Author jhr
 * @Date 2023/5/28
 */
@EnableEurekaClient
@SpringBootApplication
public class ApplicationConfigClient3355 {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationConfigClient3355.class, args);
    }
}
