package com.atguigu.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 *直接调用cloud-provider-hystrix-payment8001 服务下的接口
 * @Author jhr
 * @Date 2023/4/10
 */
@Component
@Service
@FeignClient(value = "CLOUD-PAYMENT-HYSTRIX-SERVICE")
public interface PaymentHystrixFeignService {
    /**
     * 调用hystrix8001正常的OK接口
     */
    @GetMapping("/payment/hystrix/ok/{id}")
    String getPaymentHystrixOk(@PathVariable("id") Integer id);

    /**
     * 调用8001hystrix8001服务timeout接口
     */
    @GetMapping("/payment/hystrix/timeout/{id}")
    String getPaymentHystrixTimeOut(@PathVariable("id") Integer id);


}
