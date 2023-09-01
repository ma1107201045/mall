package com.lingyi.mall.common.security.admin.handler;

import com.alibaba.fastjson2.JSON;
import com.lingyi.mall.common.base.util.ServerResponse;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/5/8 9:21
 * @description
 */
@Slf4j
public class JsonLogoutSuccessHandler implements LogoutSuccessHandler {

    @Override
    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        response.setStatus(HttpStatus.OK.value());
        response.setContentType(MediaType.APPLICATION_JSON.toString());
        response.setCharacterEncoding(StandardCharsets.UTF_8.toString());
        var writer = response.getWriter();
        var serverResponse = ServerResponse.success();
        writer.write(JSON.toJSONString(serverResponse));
    }
}
