package com.dp.config;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.server.ServerWebExchange;


/*
 * 路由规则
 */
public interface ICustomRule {

	
    ServiceInstance choose(ServerWebExchange exchange, DiscoveryClient discoveryClient);

}
