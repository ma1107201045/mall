package com.lingyi.mall.common.security.app.authentication.filter;

import cn.hutool.core.util.StrUtil;
import com.lingyi.mall.common.security.app.authentication.token.PhoneNumberVerificationCodeToken;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.core.log.LogMessage;
import org.springframework.lang.Nullable;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.event.InteractiveAuthenticationSuccessEvent;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.util.Assert;

import java.io.IOException;

/**
 * @Author: maweiyan
 * @Email 1107201045@qq.com
 * @DateTime: 2023/5/26 20:01
 * @Description: 手机号跟验证码认证
 */
public class PhoneNumberVerificationCodeAuthenticationFilter extends AbstractAuthenticationProcessingFilter {

    private static final AntPathRequestMatcher DEFAULT_ANT_PATH_REQUEST_MATCHER = new AntPathRequestMatcher("/maa/app/login", "POST");
    private static final String REQUEST_METHOD = "POST";
    private String phoneNumberParameter = "phoneNumber";
    private String verificationCodeParameter = "verificationCode";
    private boolean postOnly = true;


    public PhoneNumberVerificationCodeAuthenticationFilter() {
        super(DEFAULT_ANT_PATH_REQUEST_MATCHER);
    }


    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException, IOException, ServletException {
        if (this.postOnly && !REQUEST_METHOD.equals(request.getMethod())) {
            throw new AuthenticationServiceException("Authentication method not supported: " + request.getMethod());
        } else {
            String phoneNumber = this.obtainPhoneNumber(request);
            phoneNumber = phoneNumber != null ? phoneNumber.trim() : StrUtil.EMPTY;
            String obtainVerificationCode = this.obtainVerificationCode(request);
            obtainVerificationCode = obtainVerificationCode != null ? obtainVerificationCode : StrUtil.EMPTY;
            PhoneNumberVerificationCodeToken authRequest = PhoneNumberVerificationCodeToken.unauthenticated(phoneNumber, obtainVerificationCode);
            this.setDetails(request, authRequest);
            return this.getAuthenticationManager().authenticate(authRequest);
        }
    }

    @Nullable
    protected String obtainPhoneNumber(HttpServletRequest request) {
        return request.getParameter(this.phoneNumberParameter);
    }

    @Nullable
    protected String obtainVerificationCode(HttpServletRequest request) {
        return request.getParameter(this.verificationCodeParameter);
    }


    protected void setDetails(HttpServletRequest request, UsernamePasswordAuthenticationToken authRequest) {
        authRequest.setDetails(this.authenticationDetailsSource.buildDetails(request));
    }

    protected void setDetails(HttpServletRequest request, PhoneNumberVerificationCodeToken authRequest) {
        authRequest.setDetails(this.authenticationDetailsSource.buildDetails(request));
    }

    public void setPhoneNumber(String phoneNumberParameter) {
        Assert.hasText(phoneNumberParameter, "PhoneNumber parameter must not be empty or null");
        this.phoneNumberParameter = phoneNumberParameter;
    }

    public void setVerificationCodeParameter(String verificationCode) {
        Assert.hasText(verificationCode, "VerificationCode parameter must not be empty or null");
        this.verificationCodeParameter = verificationCode;
    }

    public void setPostOnly(boolean postOnly) {
        this.postOnly = postOnly;
    }
}
