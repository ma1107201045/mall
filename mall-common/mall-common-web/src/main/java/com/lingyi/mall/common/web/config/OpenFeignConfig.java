package com.lingyi.mall.common.web.config;

import cn.hutool.core.util.ObjUtil;
import com.lingyi.mall.common.bean.constant.BaseConstant;
import feign.Logger;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.MDC;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

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
    @NonNull
    public RequestInterceptor requestInterceptor() {
        return requestTemplate -> {
            // 获取原请求属性
            ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
            //判空
            if (ObjUtil.isNull(attributes)) {
                return;
            }
            // 获取原请求
            HttpServletRequest request = attributes.getRequest();
            // 获取原请求中携带的Cookie请求头
            String cookie = request.getHeader(BaseConstant.COOKIE);
            // 将cookie同步到新的请求的请求头中
            requestTemplate.header(BaseConstant.COOKIE, cookie);
            // 将trackId 同步到新的请求的请求头中
            requestTemplate.header(BaseConstant.TRACK_ID, MDC.get(BaseConstant.TRACK_ID));
        };

    }
}
