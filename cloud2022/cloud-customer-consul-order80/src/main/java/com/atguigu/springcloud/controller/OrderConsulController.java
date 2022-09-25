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
public class OrderConsulController {
//    服务在consul中的名称：ServiceName
    public static final String INVOKE_URL= "http://cloud-payment-service8006";
    @Resource
    RestTemplate restTemplate;
    @GetMapping("/order/consul/paymentInfo")
    public String paymentInfo(){
//        使用restTemplate请求consul服务提供者
        String result = restTemplate.getForObject(INVOKE_URL+"/payment/consul",String.class);
        return "result:"+"\t"+result;
    }
}
