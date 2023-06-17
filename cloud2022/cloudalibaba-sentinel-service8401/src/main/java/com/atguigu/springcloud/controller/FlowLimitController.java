package com.atguigu.springcloud.controller;

import cn.hutool.core.util.IdUtil;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.atguigu.springcloud.common.AjaxResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * FlowLimitController
 *
 * @Author jhr
 * @Date 2023/6/11
 */
@RestController
@Slf4j
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
        log.info(Thread.currentThread().getName()+"\t"+"...testB");
        return "testB ===============>"+ IdUtil.fastUUID();
    }

    @GetMapping("/testD")
    public String testD() throws InterruptedException {
        TimeUnit.MICROSECONDS.sleep(1);
        log.info("testD ----------测试RT");
        return "testD ===============>"+ IdUtil.fastUUID();
    }


    /**
     * 测试，Sentinel热点key
     */
    @GetMapping("/testHotKey")
    @SentinelResource(value = "testUserKey", blockHandler = "dealTestUserKey")
    public AjaxResult testHotKey(@RequestParam(value = "p1",required = false) String p1,
                                 @RequestParam(value = "p2",required = false)String p2){
        return AjaxResult.success("--------testHotKey---------:"+p1+"-"+p2);
    }

    /**
     * 自定义输出处理，对接口不加blockHandler处理的话，返回的结果为errorPage
     * @param exception
     * @return
     */
    public String dealTestUserKey(BlockException exception){
        return "-----dealTesUserKey-----";
    }

}
