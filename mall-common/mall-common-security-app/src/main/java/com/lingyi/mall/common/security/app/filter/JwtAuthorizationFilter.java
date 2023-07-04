package com.lingyi.mall.common.security.app.filter;

import cn.hutool.core.util.StrUtil;
import cn.hutool.jwt.JWTUtil;
import com.lingyi.mall.common.security.app.constant.SecurityAppConstant;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.SpringSecurityMessageSource;
import org.springframework.security.core.authority.mapping.GrantedAuthoritiesMapper;
import org.springframework.security.core.authority.mapping.NullAuthoritiesMapper;
import org.springframework.web.filter.GenericFilterBean;

import java.io.IOException;
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
        }
        String token = request.getHeader(SecurityAppConstant.AUTHORIZATION);
        if (StrUtil.isBlank(token)) {
            this.throwException();
        }
        boolean flag = false;
        try {
            flag = JWTUtil.verify(token, SecurityAppConstant.JWT_KEY.getBytes(StandardCharsets.UTF_8));
        } catch (Exception e) {
            log.error("Error verifying token, reason: ", e);
            this.throwException();
        }
        if (!flag) {
            this.throwException();
        }
        chain.doFilter(request, response);
    }


    private boolean isIgnoreRequest(HttpServletRequest request) {
        Object value = request.getAttribute(SecurityAppConstant.IS_IGNORE_REQUEST_ATTRIBUTE);
        return Objects.nonNull(value) && (Boolean) value;
    }

    private void throwException() {
        throw new InsufficientAuthenticationException(this.message.getMessage("ExceptionTranslationFilter.insufficientAuthentication", "Full authentication is required to access this resource"));
    }

    public void setMessageSourceAccessor(MessageSourceAccessor messageSourceAccessor) {
        this.message = messageSourceAccessor;
    }
}
