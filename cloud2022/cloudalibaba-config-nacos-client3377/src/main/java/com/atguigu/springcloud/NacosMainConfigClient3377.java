package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * ${NAME}
 *
 * @Author jhr
 * @Date 2023/6/8
 */
@SpringBootApplication
@EnableDiscoveryClient
public class NacosMainConfigClient3377 {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        SpringApplication.run(NacosMainConfigClient3377.class, args);
    }
}
