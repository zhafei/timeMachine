package com.zhafei.ums.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TmGatewayRouteConfig {
    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(r -> r.path("/wechat/**")
                        .filters(f -> f.stripPrefix(1)
                                .addResponseHeader("X-Response-Default-Foo", "Default-Bar"))
                        .uri("lb://tm-wechat-service")
                        .order(0)
                )
                .route(r -> r.path("/ums/**")
                        .filters(f -> f.stripPrefix(1)
                                .addResponseHeader("X-Response-Default-Foo", "Default-Bar"))
                        .uri("lb://tm-ums-service")
                        .order(0)
                )
                .build();
    }
}
