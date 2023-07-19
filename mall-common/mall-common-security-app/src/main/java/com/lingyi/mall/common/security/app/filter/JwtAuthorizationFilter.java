package com.lingyi.mall.common.security.app.filter;

import cn.hutool.core.util.StrUtil;
import cn.hutool.jwt.JWTUtil;
import com.alibaba.fastjson2.JSON;
import com.lingyi.mall.common.security.app.constant.SecurityConstant;
import com.lingyi.mall.common.base.util.ServerResponse;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.core.SpringSecurityMessageSource;
import org.springframework.web.filter.GenericFilterBean;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/5/31 9:03
 * @description
 */
@Slf4j
public class JwtAuthorizationFilter extends GenericFilterBean {
    protected MessageSourceAccessor message = SpringSecurityMessageSource.getAccessor();

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        this.doFilter((HttpServletRequest) servletRequest, (HttpServletResponse) servletResponse, filterChain);
    }

    private void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        if (this.isIgnoreRequest(request)) {
            chain.doFilter(request, response);
            return;
        }
        String token = request.getHeader(SecurityConstant.AUTHORIZATION);
        if (StrUtil.isNotBlank(token)) {
            boolean flag = false;
            try {
                flag = JWTUtil.verify(token, SecurityConstant.JWT_KEY.getBytes(StandardCharsets.UTF_8));
            } catch (Exception e) {
                log.error("Error verifying token, reason: ", e);
            }
            if (flag) {
                chain.doFilter(request, response);
                return;
            }
        }
        write(response);
    }


    private boolean isIgnoreRequest(HttpServletRequest request) {
        Boolean value = (Boolean) request.getAttribute(SecurityConstant.IS_IGNORE_REQUEST_ATTRIBUTE);
        return Objects.nonNull(value) &&  value;
    }

    private void write(HttpServletResponse response) throws IOException {
        response.setStatus(HttpStatus.UNAUTHORIZED.value());
        response.setContentType(MediaType.APPLICATION_JSON.toString());
        response.setCharacterEncoding(StandardCharsets.UTF_8.toString());
        PrintWriter writer = response.getWriter();
        writer.write(JSON.toJSONString(ServerResponse.fail(HttpStatus.UNAUTHORIZED.value(), this.message.getMessage("ExceptionTranslationFilter.insufficientAuthentication", "Full authentication is required to access this resource"))));
        writer.flush();
    }

    public void setMessageSourceAccessor(MessageSourceAccessor messageSourceAccessor) {
        this.message = messageSourceAccessor;
    }
}
