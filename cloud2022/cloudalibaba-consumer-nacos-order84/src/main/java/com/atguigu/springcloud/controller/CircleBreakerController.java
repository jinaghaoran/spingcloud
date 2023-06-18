package com.atguigu.springcloud.controller;

import cn.hutool.core.lang.Console;
import cn.hutool.core.util.ObjUtil;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.atguigu.springcloud.common.AjaxResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentFeignService;
import com.atguigu.springcloud.service.impl.PaymentFallbackServiceImpl;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * 远程调用接口，cloudalibaba-provider-payment9003与9004服务
 *
 * @Author jhr
 * @Date 2023/6/17
 */
@RestController
@RequestMapping("/consumer")
@RequiredArgsConstructor
public class CircleBreakerController {
    //    服务名称
    public static final String PAYMENT_URL = "http://nacos-provider-payment";
    private final RestTemplate restTemplate;

    @Resource
    private PaymentFeignService paymentFeignService;   //构造方法实现注入

    @GetMapping("/fallback/{id}")
//    @SentinelResource(value = "fallback", fallback = "handlerFallback")  //负责业务异常
//    @SentinelResource(value = "fallback", blockHandler = "blockHandler")  //blockHandler 负责sentinel控制台设置的违规
    @SentinelResource(value = "fallback",fallback = "handlerFallback",blockHandler = "blockHandler",
            exceptionsToIgnore = {IllegalArgumentException.class}   //要忽略的异常

    )  //业务异常与sentinel控制台的异常同时存在
    public AjaxResult circuitBreak(@PathVariable("id") String id) {
        AjaxResult result = restTemplate.getForObject(PAYMENT_URL + "/provider/getPayment/" + id, AjaxResult.class, id);
        Console.log("result:"+result);
        if (StringUtils.equals("4", id)) {
            throw new IllegalArgumentException("IllegalArgumentException,参数非法异常！");
        } else if (result != null && ObjUtil.isEmpty(result.get("data"))) {
            throw new NullPointerException("NullPointerException,服务器返回空！");
        }
        return result;
    }

    /**
     * 本例子是配置fallback
     */
    public AjaxResult handlerFallback(@PathVariable("id") String id, Throwable e) {
        Payment payment = new Payment(Long.valueOf(id), "null");
        return new AjaxResult(444, "兜底异常处理，handlerFallback，exception内容：" + e.getMessage(), payment);
    }

    /**
     * 此例子是blockHandler
     */
    public AjaxResult blockHandler(@PathVariable("id") String id, BlockException blockException){
        Payment payment = new Payment(Long.valueOf(id), "null");
        return new AjaxResult(555, "Blocked by Sentinel BlockHandler，exception内容：" + blockException.getMessage(),payment);
    }


    /**
     * feign 实例，远程调用接口，自定义的兜底方法
     */
    @GetMapping("/feign/{id}")
    public AjaxResult feignClient(@PathVariable("id") String id) {
        return paymentFeignService.getPaymentById(id);
    }


}
