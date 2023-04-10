package com.atguigu.springcloud.config;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * ApplicationContextConfig
 *
 * @Author jhr
 * @Date 2022/7/20
 */
@Configuration
public class ApplicationContextConfig {
    @Bean
//    @LoadBalanced    //注释掉表示是启用自己的
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
