package com.lingyi.mall.security.admin.handler;

import com.alibaba.fastjson2.JSON;
import com.lingyi.mall.common.core.util.ServerResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/5/10 9:38
 * @description
 */
@Slf4j
public class JsonAccessDeniedHandler implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException exception) throws IOException {
        log.error("授权失败，错误原因:", exception);
        response.setStatus(HttpStatus.FORBIDDEN.value());
        response.setContentType(MediaType.APPLICATION_JSON.toString());
        response.setCharacterEncoding(StandardCharsets.UTF_8.toString());
        var writer = response.getWriter();
        var serverResponse = ServerResponse.fail(HttpStatus.FORBIDDEN.value(), exception.getLocalizedMessage());
        writer.write(JSON.toJSONString(serverResponse));
        writer.flush();
    }
}
