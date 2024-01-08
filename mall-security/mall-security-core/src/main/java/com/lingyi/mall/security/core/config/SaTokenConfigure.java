package com.lingyi.mall.security.core.config;

import cn.dev33.satoken.interceptor.SaInterceptor;
import com.lingyi.mall.security.core.constant.NoAuthUrlConstant;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Author: maweiyan
 * @Email 1107201045@qq.com
 * @DateTime: 2024/1/8 20:38
 * @Description:
 */
@Component
public class SaTokenConfigure implements WebMvcConfigurer {

    /**
     * 注册 Sa-Token 拦截器，打开注解式鉴权功能
     *
     * @param registry 。。
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 注册 Sa-Token 拦截器，打开注解式鉴权功能
        registry.addInterceptor(new SaInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns(NoAuthUrlConstant.IGNORE_URL_ARRAY);
    }
}
