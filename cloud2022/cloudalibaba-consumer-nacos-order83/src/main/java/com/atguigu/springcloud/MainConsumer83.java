package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 调用nacos服务：nacos-provider-payment
 * @Author jhr
 * @Date 2023/6/4
 */
@SpringBootApplication
@EnableDiscoveryClient
public class MainConsumer83 {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        SpringApplication.run(MainConsumer83.class,args);
    }
}
