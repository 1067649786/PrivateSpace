package com.lyh.zone.feign;

import com.lyh.zone.common.base.JsonResult;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Description
 * @Author ygy
 * @Date 2020/4/30
 */
@FeignClient(value = "${auth.server-spring-name:service}")
public interface ValidateClient {

    @RequestMapping(path = "${auth.validate-url:/user/validate}",method = RequestMethod.GET)
    JsonResult validateUrl();
}
