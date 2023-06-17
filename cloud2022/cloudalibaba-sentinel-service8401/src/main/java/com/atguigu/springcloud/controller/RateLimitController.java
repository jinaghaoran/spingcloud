package com.atguigu.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.atguigu.springcloud.common.AjaxResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.myhandler.CustomerBlockHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 按资源名称限流，与按照URL地址限流的实现
 *
 * @Author jhr
 * @Date 2023/6/17
 */
@RestController
public class RateLimitController {
    /**
     * 自定义了流控的方式
     *
     * @return
     */
    @GetMapping("/byResource")
    @SentinelResource(value = "byResource", blockHandler = "handleException")
    public AjaxResult byResource() {
        return AjaxResult.success("按资源名称限流测试--->Sentinel限流控制台", new Payment(2023L, "serial001"));
    }

    /**
     * 自定义的返回方法，
     *
     * @param exception
     * @return
     */
    public AjaxResult handleException(BlockException exception) {
        return new AjaxResult(444, "exception handle in method" + exception.getClass().getCanonicalName() + "\t服务不可用！");
    }

    /**
     * URL形式的限流，使用了系统默认的
     *
     * @return
     */
    @GetMapping("/rateLimit/byUrl")
    @SentinelResource(value = "byUrl")
    public AjaxResult byUrl() {
        return new AjaxResult(200, "按URL限流测试OK", new Payment(2023L, "serial002"));
    }


    /**
     * 测试自定义全局的限流处理
     * CustomerBlockHandler类下的handlerException方法
     */
    @GetMapping("/rateLimit/customerHandler")
    @SentinelResource(value = "customerBlockHandler",
            blockHandlerClass = CustomerBlockHandler.class,
            blockHandler = "handlerException")
    public AjaxResult handlerExceptionDemo() {
        return AjaxResult.success("按客户自定义限流处理逻辑");
    }
}
