package com.lyh.zone.interceptor;

import com.lyh.zone.common.constant.CommonConstant;
import com.lyh.zone.common.constant.Constant;
import com.lyh.zone.common.utils.Commons;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 项目名称：zone
 * 类名称：IndexInterceptor
 * 类描述：前台拦截器
 */
@Component
public class IndexInterceptor implements HandlerInterceptor {

    @Autowired
    private Commons commons;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        String requestType=request.getHeader("X-Requested-With");
        //非ajax请求
        if(!"XMLHttpRequest".equals(requestType)){
            //工具类
            request.setAttribute("commons",commons);
            //菜单
            //request.setAttribute("menus", Constant.MENUS);
        }
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
