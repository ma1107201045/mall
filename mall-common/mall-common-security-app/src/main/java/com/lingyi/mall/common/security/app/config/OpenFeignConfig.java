package com.lingyi.mall.common.security.app.config;

import com.lingyi.mall.common.base.constant.BaseConstant;
import feign.Logger;
import feign.RequestInterceptor;
import org.slf4j.MDC;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.lang.NonNull;

/**
 * @Author: maweiyan
 * @Email 1107201045@qq.com
 * @DateTime: 2023/5/6 22:17
 * @Description:
 */
@Configuration(proxyBeanMethods = false)
public class OpenFeignConfig {

    @Bean
    Logger.Level feignLevel() {
        return Logger.Level.FULL;
    }

    @Bean
    @NonNull
    public RequestInterceptor requestInterceptor() {
        // 将trackId 同步到新的请求的请求头中
        return requestTemplate -> requestTemplate.header(BaseConstant.TRACK_ID_NAME, MDC.get(BaseConstant.TRACK_ID_NAME));
    }
}
