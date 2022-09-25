package com.atguigu.springcloud.dao;

import com.atguigu.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * PaymentDao
 * dao层接口
 * @Author jhr
 * @Date 2022/7/17
 */
@Mapper
public interface PaymentDao {
//    增删改查省略，直接使用添加，删除
    public int create(Payment payment);

    public Payment getPaymentById(@Param("id") Long id);

}
