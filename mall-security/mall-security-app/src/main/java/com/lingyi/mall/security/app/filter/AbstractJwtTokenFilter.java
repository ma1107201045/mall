package com.lingyi.mall.security.app.filter;

import com.lingyi.mall.security.app.constant.SecurityConstant;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.filter.GenericFilterBean;

import java.io.IOException;
import java.util.Arrays;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/8/11 9:14
 * @description TODO 续期待优化（正常token过期跟加入黑名单过期无法区分，导致token续期有误）
 */
public abstract class AbstractJwtTokenFilter extends GenericFilterBean {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        if (this.isIgnoreRequest(servletRequest)) {
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }
        this.doFilter((HttpServletRequest) servletRequest, (HttpServletResponse) servletResponse, filterChain);
    }

    private boolean isIgnoreRequest(ServletRequest request) {
        return Arrays.stream(SecurityConstant.IGNORE_REQUEST_MATCHER_ARRAY).anyMatch(requestMatcher -> requestMatcher.matcher((HttpServletRequest) request).isMatch());
    }

    /**
     * 执行器
     *
     * @param request  请求
     * @param response 响应
     * @param chain    。。
     * @throws IOException。。
     * @throws ServletException。。
     */
    protected abstract void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException;
}
