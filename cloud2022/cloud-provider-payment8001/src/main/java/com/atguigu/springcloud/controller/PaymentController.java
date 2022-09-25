package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentService;
import com.atguigu.springcloud.service.impl.PaymentServiceImpl;
import com.sun.corba.se.spi.ior.IdentifiableFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.websocket.server.PathParam;
import java.util.List;

/**
 * PaymentController
 *  controller
 * @Author jhr
 * @Date 2022/7/17
 */
@RestController
@Slf4j
public class PaymentController {
    @Resource
    PaymentService paymentService;
    @Resource
    DiscoveryClient discoveryClient;
    @Value("${server.port}")
    private String serverPort;  //获取端口，多个服务调用不同端口

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
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){
        log.info("id:{}"+id);
       log.info("logger");
        if (ObjectUtils.isEmpty(id)){
            return  new CommonResult<>(400,"id不能为空");
        }else {
            Payment payment = paymentService.getPaymentById(id);
            if (!ObjectUtils.isEmpty(payment)){
                return new CommonResult<>(200,"查询成功"+serverPort,payment);
            }
            return new CommonResult<>( 500,"结果为空"+serverPort,null);
        }
    }

    @GetMapping(value = "/payment/discovery")
    public String discovery(){
        List<String> services = discoveryClient.getServices();
        for (String service : services) {
            log.info("service:"+service);
        }
        List<ServiceInstance> instances = discoveryClient.getInstances("cloud-payment-service");
        for (ServiceInstance instance : instances) {
            log.info("instance:");
            log.info(instance.getHost()+"\t"+instance.getUri()+"\t"+"\t"+instance.getInstanceId()+instance.toString());
        }
        return "payment/discovery";
    }
}
