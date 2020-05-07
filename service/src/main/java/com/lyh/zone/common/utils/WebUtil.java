package com.lyh.zone.common.utils;

import com.lyh.zone.common.constant.CommonConstant;
import com.lyh.zone.entity.TbUser;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 项目名称：zone
 * 类名称：WebUtil
 * 类描述：
 */
public class WebUtil {

    public static TbUser currentUser(HttpServletRequest request,HttpServletResponse response){
        TbUser user=new TbUser();
        String cookieKey=CommonConstant.USER_ID_COOKIE;
        //获取cookie信息
        String userCookie=getCookie(request,cookieKey);
        //1.cookie为空，直接清楚
        if(StringUtils.isEmpty(userCookie)){
            CookieUtil.removeCookie(response,cookieKey);
            return null;
        }
        //2.解密cookie
        String cookieInfo=null;
        //cookie 私钥
        String secret=CommonConstant.USER_COOKIE_SECRET;
        try{
            cookieInfo=new DESUtils(secret).decryptString(userCookie);
        } catch (RuntimeException e){
            e.printStackTrace();
        }
        //3.异常或解密问题，直接清楚cookie信息
        if(StringUtils.isEmpty(cookieInfo)){
            CookieUtil.removeCookie(response,cookieKey);
            return null;
        }
        String[] userInfo=cookieInfo.split("~");
        //4.规则不匹配
        if(userInfo.length<3){
            CookieUtil.removeCookie(response,cookieKey);
            return null;
        }
        String userId=userInfo[0];
        String oldTime=userInfo[1];
        String maxAge=userInfo[2];
        //5.判定时间区间，超时的cookie清理掉
        if(!"-1".equals(maxAge)){
            long now=System.currentTimeMillis();
            long time=Long.parseLong(oldTime)+(Long.parseLong(maxAge)*1000);
            if(time<=now){
                CookieUtil.removeCookie(response,cookieKey);
                return null;
            }
        }
        if(userId==null||"null".equals(userId)){
            CookieUtil.removeCookie(response,cookieKey);
            return null;
        }
        user.setId(Integer.parseInt(userId));
        return user;
    }

    /**
     * 读取cookie
     * @param request
     * @param key
     * @return
     */
    public static String getCookie(HttpServletRequest request,String key){
        Cookie[] cookies=request.getCookies();
        if(null != cookies){
            for (Cookie cookie:cookies){
                if(key.equals(cookie.getName())){
                    return cookie.getValue();
                }
            }
        }
        return null;
    }

    /**
     * 用户登录状态维持
     * cookie设计为: des(私钥).encode(userId~time~maxAge)
     * @param remember  是否记住密码、此参数控制cookie的 maxAge，默认为-1（只在当前会话）<br>
     *                  记住密码默认为30天
     */
    public static void loginUser(HttpServletRequest request, HttpServletResponse response, TbUser user,boolean... remember){
        request.setAttribute("user",user);
        //获取用户的id
        String uid=user.getId()+"";
        //当前毫秒数
        long now=System.currentTimeMillis();
        //超时时间
        int maxAge=-1;
        if(remember.length>0 && remember[0]){
            maxAge=60*60*24*30;//30天
        }
        StringBuilder cookieBuilder=new StringBuilder()
                .append(uid).append("~")
                .append(now).append("~")
                .append(maxAge).append("~");

        //cookie 私钥
        String secret= CommonConstant.USER_COOKIE_SECRET;
        //加密cookie
        String userCookie=new DESUtils(secret).encryptString(cookieBuilder.toString());
        String cookieKey=CommonConstant.USER_ID_COOKIE;
        //设置用户的cookie、-1维持成session的状态
        CookieUtil.setCookie(response,cookieKey,userCookie,maxAge);
    }
}
