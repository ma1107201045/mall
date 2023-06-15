package com.lingyi.mall.common.security.admin.util;

import com.alibaba.fastjson2.JSON;
import com.lingyi.mall.common.util.ServerResponse;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.core.AuthenticationException;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/6/15 16:29
 * @description
 */
@Slf4j
public class AuthenticationUtil {

    private AuthenticationUtil() {

    }

    public static void write(HttpServletResponse response, AuthenticationException exception) {
        log.error("认证失败，错误原因:", exception);
        response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        response.setContentType(MediaType.APPLICATION_JSON.toString());
        response.setCharacterEncoding(StandardCharsets.UTF_8.toString());
        PrintWriter writer;
        try {
            writer = response.getWriter();
            writer.write(JSON.toJSONString(ServerResponse.fail(exception.getLocalizedMessage())));
            writer.flush();
        } catch (IOException e) {
            log.error("write失败，错误原因:", exception);
        }

    }
}
