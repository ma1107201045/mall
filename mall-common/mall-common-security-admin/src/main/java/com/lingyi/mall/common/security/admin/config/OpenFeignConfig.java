package com.lingyi.mall.common.security.admin.config;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.ArrayUtil;
import com.lingyi.mall.common.base.constant.BaseConstant;
import com.lingyi.mall.common.security.admin.constant.SecurityAdminConstant;
import feign.Logger;
import feign.RequestInterceptor;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.MDC;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.lang.NonNull;
import org.springframework.security.authentication.RememberMeAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

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
        return requestTemplate -> {
            // 将trackId 同步到新的请求的请求头中
            requestTemplate.header(BaseConstant.TRACK_ID_NAME, MDC.get(BaseConstant.TRACK_ID_NAME));
            // 获取原请求属性
            ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
            //判空
            if (Objects.isNull(attributes)) {
                return;
            }
            // 获取原请求
            HttpServletRequest request = attributes.getRequest();
            //解决记住密码bug（Authentication是null或者其他排除 REMEMBER_ME_COOKIE_NAME，Authentication是RememberMeAuthenticationToken带REMEMBER_ME_COOKIE_NAME）
            Cookie[] cookies = request.getCookies();
            if (ArrayUtil.isNotEmpty(cookies)) {
                //获取授权者类型
                Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
                List<String> cookieList = Arrays.stream(cookies)
                        .filter(cookie -> !cookie.getName().equals(SecurityAdminConstant.REMEMBER_ME_COOKIE_NAME) || authentication instanceof RememberMeAuthenticationToken)
                        .map(cookie -> cookie.getName() + BaseConstant.EQUAL_SIGN_CHAR + cookie.getValue())
                        .toList();
                // 将cookie同步到新的请求的请求头中
                requestTemplate.header(SecurityAdminConstant.COOKIE, CollUtil.join(cookieList, BaseConstant.SEMICOLON_CHAR));
            }

        };

    }
}
