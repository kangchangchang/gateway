package com.dp.config;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.cloud.gateway.config.LoadBalancerProperties;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.LoadBalancerClientFilter;
import org.springframework.core.io.buffer.DataBufferUtils;
import org.springframework.util.CollectionUtils;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.core.Ordered;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.core.io.buffer.DataBufferUtils;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpRequestDecorator;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static org.springframework.cloud.gateway.support.ServerWebExchangeUtils.GATEWAY_REQUEST_URL_ATTR;
import static org.springframework.cloud.gateway.support.ServerWebExchangeUtils.GATEWAY_SCHEME_PREFIX_ATTR;
/**
 * @Description 自定义负载均衡
 **/
public class CustomLoadBalancerFilter extends LoadBalancerClientFilter   {

    private final DiscoveryClient discoveryClient;

    private final List<ICustomRule> chooseRules;

    public CustomLoadBalancerFilter(LoadBalancerClient loadBalancer,
                                          LoadBalancerProperties properties,
                                          DiscoveryClient discoveryClient) {
        super(loadBalancer, properties);
        this.discoveryClient = discoveryClient;
        this.chooseRules = new ArrayList<>();
        chooseRules.add(new CustomChooseRule());
    }

    protected ServiceInstance choose(ServerWebExchange exchange) {
        if(!CollectionUtils.isEmpty(chooseRules)){
            Iterator<ICustomRule> iChooseRuleIterator = chooseRules.iterator();
            while (iChooseRuleIterator.hasNext()){
            	ICustomRule chooseRule = iChooseRuleIterator.next();
                ServiceInstance choose = chooseRule.choose(exchange,discoveryClient);
                if(choose != null){
                    return choose;
                }
            }
        }
        return loadBalancer.choose(
                 ((ServiceInstance) exchange.getAttribute(GATEWAY_REQUEST_URL_ATTR)).getHost());
    }
    
    /*
     * 降低优先级/要比CacheBodyGlobalFilter优先级低，要不然缓存不了body数据
     */
    public int getOrder() {
        return Ordered.LOWEST_PRECEDENCE;
      }
    
}
