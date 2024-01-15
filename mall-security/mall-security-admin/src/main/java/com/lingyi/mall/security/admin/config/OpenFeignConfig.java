package com.lingyi.mall.security.admin.config;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.ArrayUtil;
import cn.hutool.core.util.StrUtil;
import com.lingyi.mall.common.core.constant.BaseConstant;
import com.lingyi.mall.common.core.util.HttpUtil;
import feign.RequestInterceptor;
import feign.ResponseInterceptor;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.MDC;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.lang.NonNull;

import java.util.Arrays;
import java.util.Objects;

/**
 * @Author: maweiyan
 * @Email 1107201045@qq.com
 * @DateTime: 2023/5/6 22:17
 * @Description:
 */
@Configuration(value = "adminOpenFeignConfig", proxyBeanMethods = false)
public class OpenFeignConfig {


    @Bean
    @NonNull
    public RequestInterceptor requestInterceptor() {
        return requestTemplate -> {
            // 将trackId 同步到新的请求的请求头中
            requestTemplate.header(BaseConstant.TRACK_ID_NAME, MDC.get(BaseConstant.TRACK_ID_NAME));
            // 获取原请求
            HttpServletRequest request = HttpUtil.getRequest();
            if (Objects.isNull(request)) {
                return;
            }
            var cookies = request.getCookies();
            if (ArrayUtil.isEmpty(cookies)) {
                return;
            }
            //解决记住密码bug（Authentication是null或者其他排除 REMEMBER_ME_COOKIE_NAME，Authentication是RememberMeAuthenticationToken带REMEMBER_ME_COOKIE_NAME）
            var cookieList = Arrays.stream(cookies)
                    .toList();
            // 将cookie同步到新的请求的请求头中
            requestTemplate.header("cookie", CollUtil.join(cookieList, ","));
        };
    }


    @Bean
    @NonNull
    public ResponseInterceptor responseInterceptor() {
        return (invocationContext, chain) -> {
            var response = invocationContext.response();
            var headers = response.headers();
            var values = headers.get("cookie");
            if (CollUtil.isNotEmpty(values)) {
                var cookie = values.toArray(new String[]{})[0];
                if (StrUtil.isNotBlank(cookie)) {
                    HttpUtil.setHeader("cookie", cookie);
                }
            }
            return chain.next(invocationContext);
        };
    }
}
