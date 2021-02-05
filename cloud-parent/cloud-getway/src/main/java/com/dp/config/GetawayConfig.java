package com.dp.config;

import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.cloud.gateway.config.LoadBalancerProperties;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.cloud.gateway.filter.LoadBalancerClientFilter;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;

import reactor.core.publisher.Mono;

@Configuration
public class GetawayConfig {
	
	    @Bean
	    public LoadBalancerClientFilter loadBalancerClientFilter(LoadBalancerClient client,
	                                                             LoadBalancerProperties properties,
	                                                            DiscoveryClient discoveryClient) {
	            return new CustomLoadBalancerFilter(client, properties,discoveryClient);
	    }

}
