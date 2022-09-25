package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * PaymentMain8001
 *
 * @Author jhr
 * @Date 2022/7/16
 */
@SpringBootApplication
@EnableEurekaClient   //eureka-client设置
@EnableDiscoveryClient
public class PaymentMain8002 {
    public static void main(String[] args) {
//        ConfigurableApplicationContext run = SpringApplication.run(PaymentMain8001.class, args);
        SpringApplication.run(PaymentMain8002.class,args);
    }
}
