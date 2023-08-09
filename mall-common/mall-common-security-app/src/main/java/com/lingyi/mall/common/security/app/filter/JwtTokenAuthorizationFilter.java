package com.lingyi.mall.common.security.app.filter;

import cn.hutool.core.util.StrUtil;
import cn.hutool.jwt.JWTUtil;
import com.alibaba.fastjson2.JSON;
import com.lingyi.mall.common.security.app.constant.SecurityConstant;
import com.lingyi.mall.common.base.util.ServerResponse;
import com.lingyi.mall.common.security.app.util.CommonWriteUtil;
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
public class JwtTokenAuthorizationFilter extends GenericFilterBean {

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
            try {
                boolean flag = JWTUtil.verify(token, SecurityConstant.JWT_KEY.getBytes(StandardCharsets.UTF_8));
                if (flag) {
                    chain.doFilter(request, response);
                    return;
                }
            } catch (Exception e) {
                log.error("Error verifying token, reason: ", e);
            }
        }
        CommonWriteUtil.write(response, this.message.getMessage("ExceptionTranslationFilter.insufficientAuthentication", "Full authentication is required to access this resource"));
    }


    private boolean isIgnoreRequest(HttpServletRequest request) {
        Boolean value = (Boolean) request.getAttribute(SecurityConstant.IS_IGNORE_REQUEST_ATTRIBUTE);
        return Objects.nonNull(value) && value;
    }


    public void setMessageSourceAccessor(MessageSourceAccessor messageSourceAccessor) {
        this.message = messageSourceAccessor;
    }
}
