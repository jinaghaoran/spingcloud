package com.atguigu.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * LoadBalancer
 * 手写版本，轮训算法
 * @Author jhr
 * @Date 2023/4/10
 */
public interface LoadBalancer {
    ServiceInstance instances(List<ServiceInstance> serviceInstances);
}
