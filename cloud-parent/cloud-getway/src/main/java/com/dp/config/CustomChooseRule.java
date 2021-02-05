package com.dp.config;

import java.net.URI;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.web.server.ServerWebExchange;
import com.alibaba.fastjson.JSONObject;
import reactor.core.publisher.Flux;
import static org.springframework.cloud.gateway.support.ServerWebExchangeUtils.GATEWAY_REQUEST_URL_ATTR;

public class CustomChooseRule    implements ICustomRule {
	
    private AtomicInteger atomicInteger = new AtomicInteger(0);

    @Override
    public ServiceInstance choose(ServerWebExchange exchange, DiscoveryClient discoveryClient) {

          URI originalUrl = exchange.getAttribute(GATEWAY_REQUEST_URL_ATTR);
          String instancesId = originalUrl.getHost();                     
          Flux<DataBuffer> dataBufferFlux = exchange.getRequest().getBody();
          //获取body中的数据
          String body = FilterRequestResponseUtil.resolveBodyFromRequest(dataBufferFlux);
          //所有服务数据
          List<ServiceInstance> instances = discoveryClient.getInstances(instancesId);
          int index=0;
          
          //拦截nacos-provide服务也可拦截服务中特定url
          if(instancesId.equals("nacos-provide")){
        	 /*
        	  * 根据age中的数据访问特定的服务，例如age=25 只能访问服务a
        	  */
        	  if("POST"==exchange.getRequest().getMethodValue()) {
                  JSONObject json = JSONObject.parseObject(new String(body));
                  index =json.getString("age").hashCode() % instances.size();
        	  }else if("PUT"==exchange.getRequest().getMethodValue()) {
        		  String str=originalUrl.toString();
        		  String json=str.substring(str.lastIndexOf("/")+1, str.length());
        		  index=json.hashCode()% instances.size();
        	  }else {
        		  /*
        		   * GET Delete请求采用轮训算法
        		   */
        	       index = this.getAndIncrement() % instances.size();
        	  }

         }else {
           /*
            * 别的服务采用轮训
            */
  	       index = this.getAndIncrement() % instances.size();
         }

        return instances.get(index);
    }


    
    /**
     * 计算得到当前调用次数
     * @return
     */
    public final int getAndIncrement(){
        int current;
        int next;

        do {
            current = atomicInteger.get();
            next = current >= Integer.MAX_VALUE ? 0 : current+1;
        }while (!atomicInteger.compareAndSet(current,next));   //利用CAS保证原子操作

        return next;
    }
}

