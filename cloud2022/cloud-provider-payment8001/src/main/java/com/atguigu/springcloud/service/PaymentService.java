package com.atguigu.springcloud.service;

import com.atguigu.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * PaymentService
 *
 * @Author jhr
 * @Date 2022/7/17
 */
@Service
public interface PaymentService {
    //    增删改查省略，直接使用添加，查询
    public int create(Payment payment);

    public Payment getPaymentById(Long id);
    public List<Payment> getPayments();

}
