package com.lyh.ps.common.exception;

import com.lyh.ps.common.entity.ResultEntity;
import com.lyh.ps.common.utils.ResultUtils;
import org.apache.shiro.authz.AuthorizationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 自定义异常
 */
@ControllerAdvice
public class MyShiroException {

    /**
     * 处理shiro权限拦截异常
     *
     * @return
     */
    @ResponseBody
    @ExceptionHandler(value = AuthorizationException.class)
    public ResultEntity defaultErrorHandler(){
        return ResultUtils.createFailResultEntity("权限不足");
    }
}
