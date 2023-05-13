package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * OrderFeignController
 *
 * @Author jhr
 * @Date 2023/4/10
 */
@RestController
@RequestMapping("/customer")
@Slf4j
public class OrderFeignController {
    @Resource
    private PaymentFeignService paymentFeignService;

    @GetMapping("payment/get/{id}")
    public CommonResult<Payment> paymentFeignCustomer(@PathVariable("id") Long id){
        return paymentFeignService.getPaymentById(id);
    }
    @GetMapping("payment/getAll")
    public CommonResult<List<Payment>> paymentFeignCustomer(){
        return paymentFeignService.getPaymentAll();
    }

    @GetMapping("payment/timeout")
    public String paymentFeignTimeout(){
//        open  feign-ribbon,客户端一般等待1s，8001服务设置了三秒
        return paymentFeignService.paymentFeignTimeout();
    }
}
