package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import javax.websocket.server.PathParam;

/**
 * OrderController
 *
 * @Author jhr
 * @Date 2022/7/20
 */
@RestController
@Slf4j
public class OrderController {
    //    服务端地址,单机版
    //    public static final String PAYMENT_URL="http://localhost:8001";
//    集群版，调用8001与8002，实现负载均衡，直接调用Application名称
    public static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";
    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/customer/payment/create")
    public CommonResult<Payment> create(Payment payment) {
        log.info(payment + "");
//        System.out.println("create:");
        //        post调用
        return restTemplate.postForObject(PAYMENT_URL + "/payment/create", payment, CommonResult.class);
    }

//    getForObject 返回JSON格式数据
    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
        log.info(id + "");
        return restTemplate.getForObject(PAYMENT_URL + "/payment/get/" + id, CommonResult.class);
    }

//    Entity版，返回ResponseEntity数据格式
    @GetMapping("/consumer/paymentEntity/get/{id}")
    public CommonResult<Payment> getPaymentByIdForEntity(@PathVariable("id") Long id) {
        log.info(id + "");
        ResponseEntity<CommonResult> responseEntity = restTemplate.getForEntity(PAYMENT_URL + "/payment/get/" + id, CommonResult.class);
        if (responseEntity.getStatusCode().is2xxSuccessful()){
            return responseEntity.getBody();
        }else {
         return new CommonResult<>(444,"操作失败！！");
        }
//        return restTemplate.getForObject(PAYMENT_URL + "/payment/get/" + id, CommonResult.class);
    }


}
