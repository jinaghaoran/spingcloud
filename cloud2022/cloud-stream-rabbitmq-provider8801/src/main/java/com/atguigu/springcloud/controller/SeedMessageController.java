package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.service.IMessageProvider;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * SeedMessageController
 *
 * @Author jhr
 * @Date 2023/6/3
 */
@RestController
public class SeedMessageController {
    @Resource
    private IMessageProvider iMessageProvider;
    @GetMapping(value = "/sendMessage")
    public String sendMessage() {
        return iMessageProvider.seed();
    }
}
