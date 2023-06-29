package com.lingyi.mall.common.security.admin.handler;

import com.lingyi.mall.common.security.admin.util.CommonWriteUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import java.io.IOException;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/5/9 14:18
 * @description
 */
@Slf4j
public class JsonAuthenticationFailureHandler implements AuthenticationFailureHandler {
    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        CommonWriteUtil.write(response,exception);
    }
}
