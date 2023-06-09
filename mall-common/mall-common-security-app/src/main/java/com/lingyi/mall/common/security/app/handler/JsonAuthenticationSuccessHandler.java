package com.lingyi.mall.common.security.app.handler;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.jwt.JWTUtil;
import com.alibaba.fastjson2.JSON;
import com.lingyi.mall.common.base.entity.MemberDetailsDO;
import com.lingyi.mall.common.security.app.SecurityConfig;
import com.lingyi.mall.common.util.ServerResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/5/8 9:11
 * @description
 */
public class JsonAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException {
        response.setContentType(MediaType.APPLICATION_JSON.toString());
        response.setCharacterEncoding(StandardCharsets.UTF_8.toString());
        PrintWriter writer = response.getWriter();
        MemberDetailsDO memberDetailsDO = (MemberDetailsDO) authentication.getPrincipal();
        String authorization = JWTUtil.createToken(BeanUtil.beanToMap(memberDetailsDO), SecurityConfig.JWT_KEY.getBytes(StandardCharsets.UTF_8));
        memberDetailsDO.setAuthorization(authorization);
        writer.write(JSON.toJSONString(ServerResponse.success(memberDetailsDO)));
        writer.flush();
    }
}
