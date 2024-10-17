package com.daliantwop.cloud.daliantwopgateway.filter;

import com.alibaba.cloud.commons.lang.StringUtils;
import com.alibaba.fastjson.JSON;
import com.daliantwop.cloud.daliantwopcommon.consts.Renum;
import com.daliantwop.cloud.daliantwopcommon.response.R;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author Kevin
 * @date 2024/10/17 17:53
 */
@Component
public class AuthFilter implements GlobalFilter, Ordered {

    @Value("${secretKey:dalian-pp}")
    private String secretKey;


    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {

        ServerHttpRequest serverHttpRequest = exchange.getRequest();
        ServerHttpResponse serverHttpResponse = exchange.getResponse();
        String uri = serverHttpRequest.getURI().toString();

        //检查白名单
        if (uri.indexOf("/dalian-towp-user/login") > 0){
            return chain.filter(exchange);
        }

        String token = serverHttpRequest.getHeaders().getFirst("token");

        if (StringUtils.isBlank(token)){
            serverHttpResponse.setStatusCode(HttpStatus.UNAUTHORIZED);
            return getVoidMono(serverHttpResponse, Renum.MISSION_TOKEN);
        }

        return null;
    }


    private Mono<Void> getVoidMono(ServerHttpResponse serverHttpResponse, Renum renum) {
        serverHttpResponse.getHeaders().add("Content-Type", "application/json;charset=UTF-8");
        R<?> result = R.error(renum.getCode(), renum.getMsg());
        DataBuffer dataBuffer = serverHttpResponse.bufferFactory().wrap(JSON.toJSONString(result).getBytes());
        return serverHttpResponse.writeWith(Flux.just(dataBuffer));
    }


    @Override
    public int getOrder() {
        return -100;
    }
}
