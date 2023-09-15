package com.lingyi.mall.security.admin.handler;

import com.alibaba.fastjson2.JSON;
import com.lingyi.mall.common.core.util.ServerResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/5/8 9:11
 * @description
 */
@Slf4j
public class JsonAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException {
        log.info("登录成功：{}", authentication);
        response.setStatus(HttpStatus.OK.value());
        response.setContentType(MediaType.APPLICATION_JSON.toString());
        response.setCharacterEncoding(StandardCharsets.UTF_8.toString());
        var writer = response.getWriter();
        var principal = authentication.getPrincipal();
        var serverResponse = ServerResponse.success(principal);
        writer.write(JSON.toJSONString(serverResponse));
        writer.flush();
    }
}
