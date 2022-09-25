package com.atguigu.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * OrderZKController
 *
 * @Author jhr
 * @Date 2022/7/30
 */
@RestController
@Slf4j
public class OrderZKController {
//    8004服务在Zookeeper中的名称
    public static final String INVOKE_URL= "http://cloud-payment-service8004";
    @Resource
    RestTemplate restTemplate;
    @GetMapping("/orderZk/paymentInfo")
    public String paymentInfo(){
//        使用restTemplate请求服务
        String result = restTemplate.getForObject(INVOKE_URL+"/payment/zk",String.class);
        return "result:"+result;
    }
}
