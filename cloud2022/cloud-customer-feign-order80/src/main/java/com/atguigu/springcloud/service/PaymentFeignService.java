package com.atguigu.springcloud.service;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * PaymentFeignService
 * FeignClient 接口调用，8001服务下的接口
 * url = "http://127.0.0.1:8001" 调试使用
 * @Author jhr
 * @Date 2023/4/10
 */
@Component
@Service
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
public interface PaymentFeignService {
    /**
     * 直接调用8001，8002服务下的接口
     * @param id
     * @return
     */
    @GetMapping("payment/get/{id}")
    CommonResult<Payment> getPaymentById(@PathVariable("id") Long id);

    @GetMapping("payment/getAll")
    CommonResult<List<Payment>> getPaymentAll();
}
