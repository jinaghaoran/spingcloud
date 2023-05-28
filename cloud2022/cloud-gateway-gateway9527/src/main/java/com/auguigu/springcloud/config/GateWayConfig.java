package com.auguigu.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.ZonedDateTime;

/**
 * GateWayConfig
 *
 * @Author jhr
 * @Date 2023/5/27
 */
@Configuration
public class GateWayConfig {

    /**
     * 转发至百度新闻
     */
    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder routeLocatorBuilder){
        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();
        routes.route("path_route_atguigu",
                r->r.path("/news")
                        .uri("https://news.baidu.com/news")
                ).build();
        return routes.build();
    }


    public static void main(String[] args) {
        ZonedDateTime now = ZonedDateTime.now();
        System.out.println(now);
    }
//    2023-05-27T21:45:13.828+08:00[Asia/Shanghai]
}
