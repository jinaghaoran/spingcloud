package com.atguigu.springcloud.service.impl;

import cn.hutool.core.util.IdUtil;
import com.atguigu.springcloud.dao.PaymentHystrixDao;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentHystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * PaymentServiceImpl
 * service实现类
 *
 * @Author jhr
 * @Date 2022/7/17
 */
@Service
public class PaymentHystrixServiceImpl implements PaymentHystrixService {
    @Resource
    PaymentHystrixDao paymentDao;

    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }

    @Override
    public List<Payment> getPayments() {
        return paymentDao.getPayments();
    }

    @Override
    public String paymentHystrixOk(Integer id) {
        return "线程池：" + Thread.currentThread().getName() + " paymentInfo_OK,id=" + id + "\n";
    }

//    设置了hystrix超时的处理调用，并且设置了多长时间会提示超时
    @Override
    @HystrixCommand(fallbackMethod = "paymentHystrixTimeoutHandler",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "3000")
    })
    public String paymentHystrixTimeout(Integer id) {
        int i = 1;
//        模拟出现异常
//        int a = 10 / 0;
        try {
            TimeUnit.SECONDS.sleep(i);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return "线程池：" + Thread.currentThread().getName() + " paymentInfo_Timeout," + "超时（s）" + i + "s，id=" + id + "\n";
    }

    @Override
    public String paymentHystrixTimeoutHandler(Integer id){
//        hystrix下超时或者异常的处理
        return "线程池："+Thread.currentThread().getName()+" paymentHystrixTimeoutHandler,id:"+id+"\t"+"😭😭😭😭😭😭😭" +
                "\n" +
                "8001系统超时或者异常，请稍后重试";

    }

    @Override
    @HystrixCommand(fallbackMethod = "paymentCircuitBreakerFallback",commandProperties = {
//            值在HystrixCommandProperties.class中出现
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"),  //是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "2"),  //请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "1000"),  //时间窗口期
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "50"),  //失败率达到多少后跳闸
    })
    public String paymentCircuitBreaker(Integer id) {
        if (id<0){
            throw new RuntimeException("id不能为负数");
        }
        String uuid = IdUtil.simpleUUID();
        return Thread.currentThread().getName()+"\t"+"调用成功！！"+"\t服务流水号："+uuid;
    }

    @Override
    public String paymentCircuitBreakerFallback(Integer id) {
        return "id不能为负数。请修改后重试。 id->"+id;
    }


}
