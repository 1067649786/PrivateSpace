package com.lyh.ps.psgateway;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringCloudApplication
@EnableZuulProxy
public class PsGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(PsGatewayApplication.class, args);
    }
}
