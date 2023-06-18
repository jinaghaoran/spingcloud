package com.atguigu.springcloud.service;

import com.atguigu.springcloud.common.AjaxResult;
import com.atguigu.springcloud.service.impl.PaymentFallbackServiceImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * PaymentFeignService
 *
 * @Author jhr
 * @Date 2023/6/18
 */
@Component
@FeignClient(value = "nacos-provider-payment",fallback = PaymentFallbackServiceImpl.class)
public interface PaymentFeignService {
    @GetMapping("provider/getPayment/{id}")
    AjaxResult getPaymentById(@PathVariable("id") String id);

}
