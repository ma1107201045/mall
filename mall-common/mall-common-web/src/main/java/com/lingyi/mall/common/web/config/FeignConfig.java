package com.lingyi.mall.common.web.config;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lingyi.mall.common.core.constant.BaseConstant;
import com.lingyi.mall.common.core.util.HttpUtil;
import com.lingyi.mall.common.core.util.ObjectUtil;
import feign.Logger;
import feign.Request;
import feign.RequestInterceptor;
import feign.ResponseInterceptor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.lang.NonNull;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author: maweiyan
 * @Email 1107201045@qq.com
 * @DateTime: 2023/5/6 22:17
 * @Description:
 */
@Slf4j
@Configuration(proxyBeanMethods = false)
public class FeignConfig {

    @Bean
    Logger.Level feignLevel() {
        return Logger.Level.FULL;
    }

    @Bean
    @NonNull
    public RequestInterceptor requestInterceptor(ObjectMapper objectMapper) {
        return requestTemplate -> {
            // 将trackId 同步到新的请求的请求头中
            requestTemplate.header(BaseConstant.TRACK_ID_NAME, MDC.get(BaseConstant.TRACK_ID_NAME));
            //获取原请求cookies
            var cookies = Arrays.stream(HttpUtil.getCookies())
                    .map(cookie -> cookie.getName() + "=" + cookie.getValue())
                    .collect(Collectors.joining(";"));
            // 将cookie同步到新的请求的请求头中
            requestTemplate.header("cookie", cookies);

            //解决get请求传递pojo参数，将body数据拼接到url上边
            if (!Request.HttpMethod.GET.toString().equals(requestTemplate.method())
                    || Objects.isNull(requestTemplate.body())) {
                return;
            }
            JsonNode jsonNode;
            try {
                jsonNode = objectMapper.readTree(requestTemplate.body());
                requestTemplate.body(ObjectUtil.getNull(), StandardCharsets.UTF_8);
                Map<String, Collection<String>> queries = new HashMap<>();
                HttpUtil.buildQuery(jsonNode, "", queries);
                requestTemplate.queries(queries);
            } catch (IOException e) {
                log.error("convert param error,reason：", e);
            }
        };
    }

    // @Bean
    // @NonNull
    public RequestInterceptor requestInterceptor2(ObjectMapper objectMapper) {
        return requestTemplate -> {
            // 将trackId 同步到新的请求的请求头中
            requestTemplate.header(BaseConstant.TRACK_ID_NAME, MDC.get(BaseConstant.TRACK_ID_NAME));
            // 将token同步到新的请求的请求头中
            requestTemplate.header("authorization", HttpUtil.getHeader("authorization"));

            //解决get请求传递pojo参数，将body数据拼接到url上边
            if (!Request.HttpMethod.GET.toString().equals(requestTemplate.method()) || Objects.isNull(requestTemplate.body())) {
                return;
            }
            JsonNode jsonNode;
            try {
                jsonNode = objectMapper.readTree(requestTemplate.body());
                requestTemplate.body(ObjectUtil.getNull(), StandardCharsets.UTF_8);
                Map<String, Collection<String>> queries = new HashMap<>();
                HttpUtil.buildQuery(jsonNode, BaseConstant.EMPTY_CHAR, queries);
                requestTemplate.queries(queries);
            } catch (IOException e) {
                log.error("convert param error,reason：", e);
            }
        };
    }

    @Bean
    @NonNull
    public ResponseInterceptor responseInterceptor() {
        return (invocationContext, chain) -> chain.next(invocationContext);
    }

}
