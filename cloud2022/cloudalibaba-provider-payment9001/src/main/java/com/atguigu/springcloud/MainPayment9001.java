package com.atguigu.springcloud;

import cn.hutool.core.util.IdUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.commons.util.IdUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * ${NAME}
 *
 * @Author jhr
 * @Date 2023/6/4
 */
@SpringBootApplication
@EnableDiscoveryClient
public class MainPayment9001 {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        SpringApplication.run(MainPayment9001.class, args);
    }

    @RestController
   public static class EchoController{
        @Value("${server.port}")
        private String serverPort;
        @GetMapping(value = "/nacos/echo/{name}")
        public String echo(@PathVariable String name){
            return "Hello nacos："+name+",id:"+ IdUtil.fastUUID()+ ";服务端口号"+serverPort;
        }
    }
}
