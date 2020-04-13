package com.lyh.zone.controller;

import cn.hutool.core.text.StrBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 项目名称：zone
 * 类名称：BaseController
 * 类描述：
 */
public class BaseController {
    protected final Logger log = LoggerFactory.getLogger(getClass());

    //默认主题
    public static String THEME="pinghsu";

    public String render(String pageName){
        StrBuilder themeStr=new StrBuilder("themes/");
        themeStr.append(THEME);
        themeStr.append("/");
        return themeStr.append(pageName).toString();
    }

    /**
     * 404页面
     * @return
     */
    public String render_404(){
        return "error/404";
    }
}
