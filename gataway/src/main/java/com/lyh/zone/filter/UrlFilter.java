package com.lyh.zone.filter;

import com.lyh.zone.comfig.GatawayConfig;
import com.lyh.zone.common.base.JsonResult;
import com.lyh.zone.common.utils.URIUtils;
import com.lyh.zone.common.utils.WebUtil;
import com.lyh.zone.feign.ValidateClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @Description
 * @Author ygy
 * @Date 2020/4/29
 */
@Component
public class UrlFilter implements GlobalFilter {

    @Autowired
    GatawayConfig gatawayConfig;

    @Autowired
    ValidateClient validateClient;

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        ServerHttpRequest request=exchange.getRequest();

        /**
         * 忽略的uri
         */
        String uri=request.getURI().getPath();
        for (String ignoreUri : gatawayConfig.getIgnoreUris()){
            if (URIUtils.matching(ignoreUri, uri)){
                return chain.filter(exchange);
            }
        }

        JsonResult jsonResult=validateClient.validateUrl();
        if(!jsonResult.isFlag()){
            return fallBack(exchange);
        }

        return chain.filter(exchange);
    }

    private Mono<Void> fallBack(ServerWebExchange exchange){
        ServerHttpResponse response=exchange.getResponse();
        response.setStatusCode(HttpStatus.SEE_OTHER);
        response.getHeaders().set(HttpHeaders.LOCATION,"localhost:8080/user/login");
        return exchange.getResponse().setComplete();
    }
}
