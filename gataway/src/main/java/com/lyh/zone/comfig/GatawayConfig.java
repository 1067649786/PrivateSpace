package com.lyh.zone.comfig;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;

import java.util.Set;

/**
 * @Description
 * @Author ygy
 * @Date 2020/4/29
 */
@Configuration
@RefreshScope
public class GatawayConfig {

    @Value("${auth.ignore-uri:/user/login,/user/captcha}")
    private Set<String> ignoreUris;

    public Set<String> getIgnoreUris() {
        return ignoreUris;
    }

    public void setIgnoreUris(Set<String> ignoreUris) {
        this.ignoreUris = ignoreUris;
    }
}
