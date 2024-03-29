package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * ${NAME}
 *
 * @Author jhr
 * @Date 2023/6/17
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients    //激 活feign
public class MainNacosCustomer84 {
    public static void main(String[] args) {
        SpringApplication.run(MainNacosCustomer84.class,args);
        System.out.println("Hello world!");
    }
}
