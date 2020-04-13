package com.lyh.zone.interceptor;

import com.lyh.zone.common.utils.CookieUtil;
import com.lyh.zone.common.utils.WebUtil;
import com.lyh.zone.entity.TbUser;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 项目名称：zone
 * 类名称：LoginInterceptor
 * 类描述：
 */
@Component
public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        TbUser user = WebUtil.currentUser(request,response);
        //如果user不为空则放行
        if(null != user){
            return true;
        }
        //否则拦截并跳转到登录
        response.sendRedirect("/user/login");
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
