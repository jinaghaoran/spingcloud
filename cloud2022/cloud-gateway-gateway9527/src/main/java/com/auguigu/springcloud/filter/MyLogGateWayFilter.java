package com.auguigu.springcloud.filter;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Date;

/**
 * MyLogGateWayFilter
 *
 * @Author jhr
 * @Date 2023/5/27
 */
@Component
@Slf4j
public class MyLogGateWayFilter implements GlobalFilter, Ordered {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        log.info("********MyLogGateWayFilter.filter****** "+ new Date());
//       获取参数，是否有uname
        String uname = exchange.getRequest().getQueryParams().getFirst("uname");
        if (StringUtils.isEmpty(uname)){
            log.info("******* username is null****");
//            为空，则返回406错误
            exchange.getResponse().setStatusCode(HttpStatus.NOT_ACCEPTABLE);   // 返回406
            return exchange.getResponse().setComplete();
        }
        System.out.println("获取到uname："+uname);
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
