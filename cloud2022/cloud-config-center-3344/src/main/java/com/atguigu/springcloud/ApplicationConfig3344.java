package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * ApplicationConfig3344
 *
 * @Author jhr
 * @Date 2023/5/28
 */
@EnableConfigServer
@SpringBootApplication
public class ApplicationConfig3344 {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationConfig3344.class, args);
    }

}
