package com.atguigu.springcloud.myhandler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.atguigu.springcloud.common.AjaxResult;

/**
 * 返回自定义设置的限流处理逻辑，公共方法使用，减少代码量
 *
 * @Author jhr
 * @Date 2023/6/17
 */
public class CustomerBlockHandler {
    public static AjaxResult handlerException(BlockException exception){
        return new AjaxResult(444, "全局自定义异常处理。global handlerException----1");
    }

    public static AjaxResult handlerException2(BlockException exception){
        return new AjaxResult(444, "全局自定义异常处理。global handlerException----2");
    }


}
