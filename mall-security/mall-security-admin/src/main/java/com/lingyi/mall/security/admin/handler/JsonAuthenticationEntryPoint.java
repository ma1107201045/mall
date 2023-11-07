package com.lingyi.mall.security.admin.handler;

import com.alibaba.fastjson2.JSON;
import com.lingyi.mall.common.core.util.ServerResponse;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/5/10 9:44
 * @description
 */
@Slf4j
public class JsonAuthenticationEntryPoint implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException {
        log.error("认证失败，错误原因:", exception);
        response.setStatus(HttpStatus.UNAUTHORIZED.value());
        response.setContentType(MediaType.APPLICATION_JSON.toString());
        response.setCharacterEncoding(StandardCharsets.UTF_8.toString());
        var writer = response.getWriter();
        var serverResponse = ServerResponse.fail(HttpStatus.UNAUTHORIZED.value(), exception.getLocalizedMessage());
        writer.write(JSON.toJSONString(serverResponse));
        writer.flush();
    }
}
