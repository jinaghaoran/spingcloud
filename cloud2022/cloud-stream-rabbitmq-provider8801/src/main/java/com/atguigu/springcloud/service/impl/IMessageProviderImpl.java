package com.atguigu.springcloud.service.impl;

import cn.hutool.core.lang.Console;
import cn.hutool.core.util.IdUtil;
import com.atguigu.springcloud.service.IMessageProvider;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * IMessageProviderImpl
 *
 * @Author jhr
 * @Date 2023/6/3
 */
@Component
@EnableBinding(Source.class)
public class IMessageProviderImpl implements IMessageProvider {

    @Resource
    private MessageChannel output;

    @Override
    public String seed() {
        String uuid = IdUtil.randomUUID();
        output.send(MessageBuilder.withPayload(uuid).build());
        Console.log("uuid"+uuid);
        return uuid;
    }
}
