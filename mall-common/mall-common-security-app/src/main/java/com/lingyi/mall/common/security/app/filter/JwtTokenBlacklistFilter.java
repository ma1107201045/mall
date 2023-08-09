package com.lingyi.mall.common.security.app.filter;

import cn.hutool.core.util.ObjUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.jwt.JWTUtil;
import com.alibaba.fastjson2.JSON;
import com.lingyi.mall.common.base.util.ServerResponse;
import com.lingyi.mall.common.cache.util.RedisUtil;
import com.lingyi.mall.common.security.app.constant.SecurityConstant;
import com.lingyi.mall.common.security.app.util.AppRedisKeyUtil;
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

/**
 * @Author: maweiyan
 * @Email 1107201045@qq.com
 * @DateTime: 2023/8/6 19:43
 * @Description: token黑名单过滤器
 */
@Slf4j
public class JwtTokenBlacklistFilter extends GenericFilterBean {

    protected MessageSourceAccessor message = SpringSecurityMessageSource.getAccessor();
    private RedisUtil redisUtil;
    private AppRedisKeyUtil appRedisKeyUtil;

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        this.doFilter((HttpServletRequest) servletRequest, (HttpServletResponse) servletResponse, filterChain);
    }

    private void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        String token = request.getHeader(SecurityConstant.AUTHORIZATION);
        if (StrUtil.isNotBlank(token)) {
            String tokenKey = appRedisKeyUtil.getTokenBlacklistKey(token);
            Integer tokenValue = redisUtil.get(tokenKey, Integer.class);
            if (ObjUtil.isNull(tokenValue)) {
                chain.doFilter(request, response);
                return;
            }
        }
        CommonWriteUtil.write(response, this.message.getMessage("JwtTokenBlacklistFilter.tokenError", "JwtToken is error"));
    }

    public void setMessageSourceAccessor(MessageSourceAccessor messageSourceAccessor) {
        this.message = messageSourceAccessor;
    }

    public void setRedisUtil(RedisUtil redisUtil) {
        this.redisUtil = redisUtil;
    }

    public void setAppRedisKeyUtil(AppRedisKeyUtil appRedisKeyUtil) {
        this.appRedisKeyUtil = appRedisKeyUtil;
    }
}
