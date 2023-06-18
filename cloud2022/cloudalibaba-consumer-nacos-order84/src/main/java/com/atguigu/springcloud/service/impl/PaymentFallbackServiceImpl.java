package com.atguigu.springcloud.service.impl;

import com.atguigu.springcloud.common.AjaxResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentFeignService;
import org.springframework.stereotype.Component;

/**
 * PaymentFallbackServiceImpl
 *
 * @Author jhr
 * @Date 2023/6/18
 */
@Component
public class PaymentFallbackServiceImpl implements PaymentFeignService {

    @Override
    public AjaxResult getPaymentById(String id) {
        return new AjaxResult(44444, "服务降级返回：PaymentFallbackService.fallbackMethod", new Payment(Long.valueOf(id), "errorFallback"));
    }
}
