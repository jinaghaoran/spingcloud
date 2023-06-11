package com.atguigu.springcloud.controller;

import cn.hutool.core.util.IdUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * FlowLimitController
 *
 * @Author jhr
 * @Date 2023/6/11
 */
@RestController
public class FlowLimitController {
    @GetMapping("/testA")
    public String testA(){
//        try {
////            TimeUnit.MICROSECONDS.sleep(80000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        return "testA ===============>"+ IdUtil.fastUUID();
    }

    @GetMapping("/testB")
    public String testB(){
        return "testB ===============>"+ IdUtil.fastUUID();
    }
}
