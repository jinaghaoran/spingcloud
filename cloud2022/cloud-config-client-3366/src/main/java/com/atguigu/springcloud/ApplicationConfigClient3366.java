package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * ApplicationConfigClient3366
 *
 * @Author jhr
 * @Date 2023/6/3
 */
@SpringBootApplication
@EnableEurekaClient
public class ApplicationConfigClient3366
{
    public static void main(String[] args) {
        SpringApplication.run(ApplicationConfigClient3366.class,args);
    }
}
