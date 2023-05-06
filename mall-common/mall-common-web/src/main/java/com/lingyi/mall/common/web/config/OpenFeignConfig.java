package com.lingyi.mall.common.web.config;

import com.lingyi.mall.common.constant.BaseConstant;
import feign.Logger;
import feign.RequestInterceptor;
import org.slf4j.MDC;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: maweiyan
 * @Email 1107201045@qq.com
 * @DateTime: 2023/5/6 22:17
 * @Description:
 */
@Configuration(proxyBeanMethods = false)
public class OpenFeignConfig {

    @Bean
    Logger.Level level() {
        return Logger.Level.FULL;
    }

    @Bean
    public RequestInterceptor requestInterceptor() {
        return requestTemplate -> requestTemplate.header(BaseConstant.TRACK_ID, MDC.get(BaseConstant.TRACK_ID));
    }
}
