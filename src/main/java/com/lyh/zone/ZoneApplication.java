package com.lyh.zone;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.lyh.zone.mapper")
public class ZoneApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZoneApplication.class, args);
    }

}
