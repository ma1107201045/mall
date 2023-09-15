package com.lingyi.mall.security.app.filter;

import cn.hutool.core.util.ObjUtil;
import cn.hutool.core.util.StrUtil;
import com.lingyi.mall.common.redis.util.RedisUtil;
import com.lingyi.mall.security.app.constant.SecurityConstant;
import com.lingyi.mall.security.app.util.CommonWriteUtil;
import com.lingyi.mall.security.app.util.RedisKeyUtil;
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
    private RedisKeyUtil redisKeyUtil;

    @Override
    protected void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        var token = request.getHeader(SecurityConstant.AUTHORIZATION);
        if (StrUtil.isNotBlank(token)) {
            var tokenKey = redisKeyUtil.getTokenBlacklistKey(token);
            var tokenValue = redisUtil.get(tokenKey, Integer.class);
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

    public void setAppRedisKeyUtil(RedisKeyUtil redisKeyUtil) {
        this.redisKeyUtil = redisKeyUtil;
    }
}
