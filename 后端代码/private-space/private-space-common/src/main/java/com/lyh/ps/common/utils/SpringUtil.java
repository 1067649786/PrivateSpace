package com.lyh.ps.common.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * Spring上下文工具类
 */
public class SpringUtil implements ApplicationContextAware {
    private static ApplicationContext context;

    /**
     * Spring在bean初始化后会判断是不是ApplicationContextAware的子类
     * 如果该类是，setApplicationContext()方法会将容器中ApplicationContext作为参数传入进去
     * @param applicationContext
     * @throws BeansException
     */
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        context = applicationContext;
    }

    /**
     * 通过Name返回指定的Bean
     * @param beanClass
     * @param <T>
     * @return
     */
    public static <T> T getBean(Class<T> beanClass){
        return context.getBean(beanClass);
    }
}
