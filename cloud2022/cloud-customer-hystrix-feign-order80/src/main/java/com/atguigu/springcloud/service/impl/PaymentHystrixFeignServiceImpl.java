package com.atguigu.springcloud.service.impl;

import com.atguigu.springcloud.service.PaymentHystrixFeignService;
import org.springframework.stereotype.Component;

/**
 * PaymentHystrixFeignServiceImpl
 *
 * @Author jhr
 * @Date 2023/5/14
 */
@Component
public class PaymentHystrixFeignServiceImpl implements PaymentHystrixFeignService {
    @Override
    public String getPaymentHystrixOk(Integer id) {
        return "调用PaymentHystrixFeignService下getPaymentHystrixOk方法出现异常或者超时!!!";
    }

    @Override
    public String getPaymentHystrixTimeOut(Integer id) {
        return "调用PaymentHystrixFeignService下getPaymentHystrixTimeOut方法出现异常或者超时!!!";
    }
}
