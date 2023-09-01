package com.lingyi.mall.common.security.app.filter;

import cn.hutool.core.util.StrUtil;
import cn.hutool.jwt.JWTUtil;
import com.lingyi.mall.common.security.app.constant.SecurityConstant;
import com.lingyi.mall.common.security.app.util.CommonWriteUtil;
import com.lingyi.mall.common.security.app.util.JwtUtil;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.security.core.SpringSecurityMessageSource;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/5/31 9:03
 * @description
 */
@Slf4j
public class JwtTokenAuthorizationFilter extends AbstractJwtTokenFilter {

    protected MessageSourceAccessor message = SpringSecurityMessageSource.getAccessor();

    @Override
    protected void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        var token = request.getHeader(SecurityConstant.AUTHORIZATION);
        if (StrUtil.isNotBlank(token)) {
            try {
                var flag = JwtUtil.verifyToken(token);
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

    public void setMessageSourceAccessor(MessageSourceAccessor messageSourceAccessor) {
        this.message = messageSourceAccessor;
    }
}
