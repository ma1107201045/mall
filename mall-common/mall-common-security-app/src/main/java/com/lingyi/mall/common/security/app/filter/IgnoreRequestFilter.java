package com.lingyi.mall.common.security.app.filter;

import com.lingyi.mall.common.security.app.constant.SecurityAppConstant;
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
 * @datetime 2023/7/4 16:38
 * @description
 */
public class IgnoreRequestFilter extends GenericFilterBean {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        this.doFilter((HttpServletRequest) servletRequest, (HttpServletResponse) servletResponse, filterChain);
    }

    private void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        boolean flag = SecurityAppConstant.REQUEST_MATCHER_LIST.stream()
                .anyMatch(requestMatcher -> requestMatcher.matcher(request).isMatch());
        if (flag) {
            request.setAttribute(SecurityAppConstant.IS_IGNORE_REQUEST_ATTRIBUTE, true);
        }
        chain.doFilter(request, response);
    }
}
