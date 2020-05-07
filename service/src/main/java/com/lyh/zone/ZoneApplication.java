package com.lyh.zone;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@MapperScan("com.lyh.zone.mapper")
@EnableDiscoveryClient
@EnableFeignClients
public class ZoneApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZoneApplication.class, args);
    }

}
