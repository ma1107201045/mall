package com.lingyi.mall.common.security.app.filter;

import cn.hutool.core.util.ObjUtil;
import cn.hutool.core.util.StrUtil;
import com.lingyi.mall.common.cache.util.RedisUtil;
import com.lingyi.mall.common.security.app.constant.SecurityConstant;
import com.lingyi.mall.common.security.app.util.AppRedisKeyUtil;
import com.lingyi.mall.common.security.app.util.CommonWriteUtil;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.security.core.SpringSecurityMessageSource;

import java.io.IOException;

/**
 * @Author: maweiyan
 * @Email 1107201045@qq.com
 * @DateTime: 2023/8/6 19:43
 * @Description: token黑名单过滤器
 */
@Slf4j
public class JwtTokenBlacklistFilter extends AbstractJwtTokenFilter {

    protected MessageSourceAccessor message = SpringSecurityMessageSource.getAccessor();
    private RedisUtil redisUtil;
    private AppRedisKeyUtil appRedisKeyUtil;

    @Override
    protected void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
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
