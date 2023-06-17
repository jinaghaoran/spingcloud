package com.atguigu.springcloud.controller;

import cn.hutool.core.util.IdUtil;
import com.atguigu.springcloud.common.AjaxResult;
import com.atguigu.springcloud.entities.Payment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * PaymentController
 *
 * @Author jhr
 * @Date 2023/6/17
 */
@RestController
@RequestMapping("/provider")
public class PaymentController {
    @Value("${server.port}")
    private String serverPort;

    public static final String PAYMENT_URL = "http://nacos-provider-payment";

    public HashMap<String, Payment> initPayments() {
        HashMap<String, Payment> map = new HashMap<>();
        map.put("1", new Payment(1L, IdUtil.fastSimpleUUID()));
        map.put("2", new Payment(2L, IdUtil.fastSimpleUUID()));
        map.put("3", new Payment(3L, IdUtil.fastSimpleUUID()));
        return map;
    }


    @GetMapping("/getPayment/{id}")
    public AjaxResult getPayment(@PathVariable String id) {
        return AjaxResult.success("操作成功,"+serverPort,initPayments().get(id));
    }
}
