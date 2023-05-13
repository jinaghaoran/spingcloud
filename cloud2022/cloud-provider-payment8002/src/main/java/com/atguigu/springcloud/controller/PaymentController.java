package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * PaymentController
 *  controller
 * @Author jhr
 * @Date 2022/7/17
 */
@RestController
@Slf4j
public class PaymentController {
    @Autowired
    PaymentService paymentService;
    @Resource
    DiscoveryClient discoveryClient;
    @Value("${server.port}")
    private String serverPort;

    @PostMapping(value = "/payment/create")
    public CommonResult<Payment> create(@RequestBody Payment payment){
        log.info("payment:{}",payment);
        int i = paymentService.create(payment);
        System.out.println("hello");
        int sum =10/2;
        System.out.println(sum);
        System.out.println("hello");
        if (i>0){
            return new CommonResult<>(200,"插入成功"+serverPort,payment);
        }else{
            return new CommonResult<>(444,"插入失败"+serverPort,null);
        }
    }

    @GetMapping("/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
        log.info("id:" + id);
        log.info("logger");
        if (ObjectUtils.isEmpty(id)) {
            return new CommonResult<>(400, "id不能为空");
        } else {
            Payment payment = paymentService.getPaymentById(id);
            if (!ObjectUtils.isEmpty(payment)) {
                return new CommonResult<>(200, "查询成功" + serverPort, payment);
            }
            return new CommonResult<>(500, "结果为空" + serverPort, null);
        }
    }

//    服务发现
    @GetMapping(value = "/payment/discovery")
    public String discovery(){
        log.info("====discovery====");
//        发现服务，所有的service
        List<String> services = discoveryClient.getServices();
        for (String service : services) {
            log.info("service:"+service);
        }
//        绑定服务内容，即Application名称
        List<ServiceInstance> instances = discoveryClient.getInstances("cloud-payment-service");
        for (ServiceInstance instance : instances) {
            log.info("instances:");
            log.info(instance.getHost()+"\t"+instance.getUri()+"\t"+"\t"+instance.getInstanceId()+"\t"+instance.toString());
        }
        return "payment/discovery"+this.discoveryClient;
    }



    @GetMapping(value = "/payment/lb")
    public String getPaymentLB(){
        return serverPort;
    }

    /**
     * 模拟业务，暂停三秒再使用
     * @return
     */
    @GetMapping(value="/payment/feign/timeout")
    public String paymentFeignTimeout(){
        try {
            TimeUnit.SECONDS.sleep(3);
        }catch (Exception e) {
            e.printStackTrace();
        }
        return "paymentFeignTimeout:"+serverPort;
    }
}
