package com.lingyi.mall.security.app.config;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.StrUtil;
import com.lingyi.mall.common.core.constant.BaseConstant;
import com.lingyi.mall.common.core.util.HttpUtil;
import com.lingyi.mall.security.app.constant.SecurityConstant;
import feign.Logger;
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
@Configuration(proxyBeanMethods = false)
public class OpenFeignConfig {


    @Bean
    @NonNull
    public RequestInterceptor requestInterceptor() {
        // 将trackId 同步到新的请求的请求头中
        return requestTemplate -> {
            // 将trackId 同步到新的请求的请求头中
            requestTemplate.header(BaseConstant.TRACK_ID_NAME, MDC.get(BaseConstant.TRACK_ID_NAME));
            var token = HttpUtil.getHeader(SecurityConstant.AUTHORIZATION);
            if (StrUtil.isBlank(token)) {
                return;
            }
            // 将token同步到新的请求的请求头中
            requestTemplate.header(SecurityConstant.AUTHORIZATION, token);
        };
    }

    @Bean
    @NonNull
    public ResponseInterceptor responseInterceptor() {
        return invocationContext -> {
            var response = invocationContext.response();
            var headers = response.headers();
            var values = headers.get(SecurityConstant.AUTHORIZATION);
            if (CollUtil.isNotEmpty(values)) {
                var token = values.toArray(new String[]{})[0];
                if (StrUtil.isNotBlank(token)) {
                    HttpUtil.addHeader(SecurityConstant.AUTHORIZATION, token);
                }
            }
            return invocationContext.proceed();
        };
    }
}
