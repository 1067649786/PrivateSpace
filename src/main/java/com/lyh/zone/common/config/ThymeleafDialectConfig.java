package com.lyh.zone.common.config;


import com.lyh.zone.common.config.thymeleaf.dialect.ThSysDialect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 项目名称：zone
 * 类名称：ThymeleafDialectConfig
 * 类描述：
 */
@Configuration
public class ThymeleafDialectConfig {

    @Bean
    public ThSysDialect thSysDialect(){
        return new ThSysDialect();
    }
}
