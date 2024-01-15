
package com.lingyi.mall.common.web.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lingyi.mall.common.web.util.ServerResponse;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;


/**
 * @Author: maweiyan
 * @Email 1107201045@qq.com
 * @DateTime: 2023/11/2 23:44
 * @Description:
 */
@Slf4j
@RestControllerAdvice
@RequiredArgsConstructor
public class GlobalResponseBodyAdvice implements ResponseBodyAdvice<Object> {

    private final ObjectMapper objectMapper;

    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        return true;
    }

    @SneakyThrows
    @Override
    public Object beforeBodyWrite(@Nullable Object body,
                                  MethodParameter returnType,
                                  MediaType selectedContentType,
                                  Class<? extends HttpMessageConverter<?>> selectedConverterType,
                                  ServerHttpRequest request,
                                  ServerHttpResponse response) {
        //Knife4j单独处理
        if (body instanceof byte[]) {
            return body;
        }
        if (body instanceof ServerResponse<?>) {
            return body;
        }
        if (body instanceof String) {
            var res = ServerResponse.success(body);
            return objectMapper.writeValueAsString(res);
        }
        return ServerResponse.success(body);
    }
}