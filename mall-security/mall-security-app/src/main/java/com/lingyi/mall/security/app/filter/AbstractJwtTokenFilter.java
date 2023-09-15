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

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/8/11 9:14
 * @description
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
        return SecurityConstant.REQUEST_MATCHER_LIST.stream().anyMatch(requestMatcher -> requestMatcher.matcher((HttpServletRequest) request).isMatch());
    }

    protected abstract void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException;
}
