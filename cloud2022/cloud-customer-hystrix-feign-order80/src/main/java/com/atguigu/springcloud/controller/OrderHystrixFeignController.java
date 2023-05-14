package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.service.PaymentHystrixFeignService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * OrderFeignController
 *
 * @Author jhr
 * @Date 2023/4/10
 */
@RestController
@RequestMapping("/customer")
@Slf4j
//@DefaultProperties(defaultFallback = "paymentGlobalFallbackMethod")  //设置了全局处理
public class OrderHystrixFeignController {
    @Resource
    private PaymentHystrixFeignService paymentFeignService;

    @GetMapping("payment/hystrix/ok/{id}")
    public String paymentHystrixCustomer(@PathVariable("id") Integer id){
        return paymentFeignService.getPaymentHystrixOk(id);
    }


    @GetMapping("payment/hystrix/timeout/{id}")
    //    设置了hystrix超时的处理调用，并且设置了多长时间会提示超时
//    @HystrixCommand(fallbackMethod = "paymentHystrixTimeoutHandler",commandProperties = {
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "3000")
//    })
//    @HystrixCommand
    public String paymentFeignTimeout(@PathVariable("id") Integer id){
//        模拟超时情况
//        try {
//            TimeUnit.SECONDS.sleep(3);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//        模拟异常出现
        int a = 10/0;
//        open  feign-ribbon,客户端一般等待1s，8001服务设置了三秒
        return paymentFeignService.getPaymentHystrixTimeOut(id);
    }


//    单独的处理方法
    public String paymentHystrixTimeoutHandler(@PathVariable("id") Integer id){
        return "80服务超时或者出现异常，请稍后重试";
    }

//    全局的处理方法
    public String paymentGlobalFallbackMethod(){
        return "80服务出现超时或者异常，请稍后重试（全局设置的方法）";
    }
}
