package com.lyh.zone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Description
 * @Author ygy
 * @Date 2020/4/29
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class GatawayApplication {
    public static void main(String[] args) {
        SpringApplication.run(GatawayApplication.class, args);
    }
}
