package com.lyh.zone.common.config;

import com.lyh.zone.interceptor.IndexInterceptor;
import com.lyh.zone.interceptor.LoginInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.MultipartConfigElement;

/**
 * 项目名称：zone
 * 类名称：MyWebAppConfigurer
 * 类描述：
 */
@Configuration
public class MyWebAppConfigurer implements WebMvcConfigurer {

    @Autowired
    private IndexInterceptor indexInterceptor;

    @Autowired
    private LoginInterceptor loginInterceptor;

    /**
     * 注册拦截器
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        /*registry.addInterceptor(loginInterceptor).addPathPatterns("/admin/**").addPathPatterns("/user/**")
                .excludePathPatterns("/user/login").excludePathPatterns("/user/captcha");*/
        registry.addInterceptor(indexInterceptor);
    }

    /**
     * 释放静态资源
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
        // 通过addResourceHandler添加资源映射路径，然后通过addResourceLocations来指定路径。可以访问自定义upload文件夹
        registry.addResourceHandler("/upload/**").addResourceLocations("classpath:/upload/")
                .addResourceLocations("file:///" + System.getProperties().getProperty("user.home") + "/mayday/upload/");
        registry.addResourceHandler("/source/**").addResourceLocations("classpath:/templates/themes/");
        WebMvcConfigurer.super.addResourceHandlers(registry);
    }

    /**
     * 文件上传配置
     * @return
     */
    @Bean
    public MultipartConfigElement multipartConfigElement(){
        MultipartConfigFactory factory=new MultipartConfigFactory();
        //单个文件最大KB,MB
        factory.setMaxFileSize("10240KB");
        //设置总上传数据总大小
        factory.setMaxRequestSize("102400KB");
        return factory.createMultipartConfig();
    }
}
