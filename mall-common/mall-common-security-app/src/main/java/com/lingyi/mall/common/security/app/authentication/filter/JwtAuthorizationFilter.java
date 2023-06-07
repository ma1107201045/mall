package com.lingyi.mall.common.security.app.authentication.filter;

import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.jwt.JWT;
import cn.hutool.jwt.JWTUtil;
import com.lingyi.mall.common.base.entity.MemberDetailsDO;
import com.lingyi.mall.common.security.app.SecurityConfig;
import com.lingyi.mall.common.security.app.authentication.token.PhoneNumberVerificationCodeToken;
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
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.GenericFilterBean;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/5/31 9:03
 * @description
 */
@Slf4j
public class JwtAuthorizationFilter extends GenericFilterBean {
    private static final String AUTHORIZATION = "Authorization";
    protected MessageSourceAccessor messages = SpringSecurityMessageSource.getAccessor();
    private final GrantedAuthoritiesMapper authoritiesMapper = new NullAuthoritiesMapper();

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        this.doFilter((HttpServletRequest) servletRequest, (HttpServletResponse) servletResponse, filterChain);
    }

    private void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        String token = request.getHeader(AUTHORIZATION);
        if (StrUtil.isBlank(token)) {
            this.throwException();
        }
        boolean flag = false;
        try {
            flag = JWTUtil.verify(token, SecurityConfig.JWT_KEY.getBytes(StandardCharsets.UTF_8));
        } catch (Exception e) {
            log.error("Error verifying token, reason: ", e);
            this.throwException();
        }
        if (!flag) {
            this.throwException();
        }
        MemberDetailsDO memberDetails = this.getMemberDetailsEntity(token);
        this.setAuthentication(memberDetails);
        chain.doFilter(request, response);
    }

    private void throwException() {
        throw new InsufficientAuthenticationException(this.messages.getMessage("ExceptionTranslationFilter.insufficientAuthentication", "Full authentication is required to access this resource"));
    }

    private MemberDetailsDO getMemberDetailsEntity(String token) {
        JWT jwt = JWTUtil.parseToken(token);
        JSONObject payloads = jwt.getPayloads();
        return payloads.toBean(MemberDetailsDO.class);
    }

    private void setAuthentication(MemberDetailsDO memberDetailsDO) {
        SecurityContext securityContext = SecurityContextHolder.getContext();
        PhoneNumberVerificationCodeToken token = new PhoneNumberVerificationCodeToken(memberDetailsDO.getPhoneNumber(),
                memberDetailsDO.getVerificationCode(),
                this.authoritiesMapper.mapAuthorities(memberDetailsDO.getAuthorities()));
        securityContext.setAuthentication(token);
    }
}
