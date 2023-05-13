package com.atguigu.springcloud.service;

import com.atguigu.springcloud.entities.Payment;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * PaymentService
 *
 * @Author jhr
 * @Date 2022/7/17
 */
@Service
public interface PaymentHystrixService {
    //    增删改查省略，直接使用添加，查询
    public int create(Payment payment);

    public Payment getPaymentById(Long id);
    public List<Payment> getPayments();

//  使用hystrix模拟成功状态
    public String paymentHystrixOk(Integer id);
//    模拟超时情况
//    hystrix对超时处理
    public String paymentHystrixTimeout(Integer id);

//    超时hystrix的处理
    public String paymentHystrixTimeoutHandler(Integer id);
}
