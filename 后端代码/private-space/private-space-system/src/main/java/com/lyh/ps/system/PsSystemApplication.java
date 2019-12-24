package com.lyh.ps.system;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(basePackages = {"com.lyh.ps.system.mapper"})
@SpringBootApplication
public class PsSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(PsSystemApplication.class,args);
    }
}
