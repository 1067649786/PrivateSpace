package com.lyh.zone.common.config;

import com.lyh.zone.common.constant.CommonConstant;
import com.lyh.zone.common.constant.Constant;
import com.lyh.zone.service.TbMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextRefreshedEvent;

/**
 * 项目名称：zone
 * 类名称：StartupConfig
 * 类描述：
 */
/*@Configuration
public class StartupConfig implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private TbMenuService menuService;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        this.loadMenus();
    }

    *//**
     * 加载菜单
     *//*
    private void loadMenus(){
        Constant.MENUS=menuService.findMenus();
    }
}*/

