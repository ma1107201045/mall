package com.lingyi.mall.security.app.config;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.StrUtil;
import com.lingyi.mall.common.core.constant.BaseConstant;
import com.lingyi.mall.common.core.util.HttpUtil;
import feign.RequestInterceptor;
import feign.ResponseInterceptor;
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
@Configuration(value = "appOpenFeignConfig", proxyBeanMethods = false)
public class OpenFeignConfig {


    @Bean
    @NonNull
    public RequestInterceptor requestInterceptor() {
        // 将trackId 同步到新的请求的请求头中
        return requestTemplate -> {
            // 将trackId 同步到新的请求的请求头中
            requestTemplate.header(BaseConstant.TRACK_ID_NAME, MDC.get(BaseConstant.TRACK_ID_NAME));
            var token = HttpUtil.getHeader("authorization");
            if (StrUtil.isBlank(token)) {
                return;
            }
            // 将token同步到新的请求的请求头中
            requestTemplate.header("authorization", token);
        };
    }

    @Bean
    @NonNull
    public ResponseInterceptor responseInterceptor() {
        return (invocationContext, chain) -> invocationContext.proceed();
    }
}
