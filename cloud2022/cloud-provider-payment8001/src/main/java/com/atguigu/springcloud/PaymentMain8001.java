package com.atguigu.springcloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Controller;

/**
 * PaymentMain8001
 *
 * @Author jhr
 * @Date 2022/7/16
 */
@SpringBootApplication
@EnableEurekaClient   //eureka-client设置
@EnableDiscoveryClient   //服务发现discovery
public class PaymentMain8001 {
    public static void main(String[] args) {
//        ConfigurableApplicationContext run = SpringApplication.run(PaymentMain8001.class, args);
        SpringApplication.run(PaymentMain8001.class,args);
    }
}
