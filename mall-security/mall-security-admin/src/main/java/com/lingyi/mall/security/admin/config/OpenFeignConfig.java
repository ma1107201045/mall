package com.lingyi.mall.security.admin.config;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.ArrayUtil;
import com.lingyi.mall.common.core.constant.BaseConstant;
import com.lingyi.mall.common.core.util.HttpUtil;
import com.lingyi.mall.security.admin.constant.SecurityConstant;
import feign.Logger;
import feign.RequestInterceptor;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.MDC;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.lang.NonNull;
import org.springframework.security.authentication.RememberMeAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Arrays;

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
        return requestTemplate -> {
            // 将trackId 同步到新的请求的请求头中
            requestTemplate.header(BaseConstant.TRACK_ID_NAME, MDC.get(BaseConstant.TRACK_ID_NAME));
            // 获取原请求
            HttpServletRequest request = HttpUtil.getRequest();
            //解决记住密码bug（Authentication是null或者其他排除 REMEMBER_ME_COOKIE_NAME，Authentication是RememberMeAuthenticationToken带REMEMBER_ME_COOKIE_NAME）
            var cookies = request.getCookies();
            if (ArrayUtil.isNotEmpty(cookies)) {
                //获取授权者类型
                var authentication = SecurityContextHolder.getContext().getAuthentication();
                var cookieList = Arrays.stream(cookies)
                        .filter(cookie -> !cookie.getName().equals(SecurityConstant.REMEMBER_ME_COOKIE_NAME) || authentication instanceof RememberMeAuthenticationToken)
                        .map(cookie -> cookie.getName() + BaseConstant.EQUAL_SIGN_CHAR + cookie.getValue())
                        .toList();
                // 将cookie同步到新的请求的请求头中
                requestTemplate.header(SecurityConstant.COOKIE, CollUtil.join(cookieList, BaseConstant.SEMICOLON_CHAR));
            }

        };
    }
}
