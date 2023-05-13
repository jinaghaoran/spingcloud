package com.atguigu.springcloud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * TestController
 *
 * @Author jhr
 * @Date 2022/7/17
 */
@RestController
public class TestController {
    @GetMapping("/test")
    public String test(){
        return "hello World"+"0001";
    }
}
