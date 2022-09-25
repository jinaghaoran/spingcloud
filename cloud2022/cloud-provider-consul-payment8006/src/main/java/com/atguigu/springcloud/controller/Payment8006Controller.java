package com.atguigu.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * PayMent8004Controller
 *
 * @Author jhr
 * @Date 2022/7/30
 */
@RestController
public class Payment8006Controller {
    @Value("${server.port}")
    private String serverPort;

    @RequestMapping("/payment/consul")
    public String paymentZk(){
        return "springCloud with consul"+serverPort+"\t"+ UUID.randomUUID();
    }
}
