package com.lingyi.mall.common.security.app.token;

import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.util.Assert;

import java.io.Serial;
import java.util.Collection;

/**
 * @Author: maweiyan
 * @Email 1107201045@qq.com
 * @DateTime: 2023/5/27 0:18
 * @Description:
 */
public class PhoneNumberVerificationCodeToken extends AbstractAuthenticationToken {

    @Serial
    private static final long serialVersionUID = -3400249664320819980L;
    private final Object principal;
    private Object credentials;

    public PhoneNumberVerificationCodeToken(Object principal, Object credentials) {
        super(null);
        this.principal = principal;
        this.credentials = credentials;
        this.setAuthenticated(false);
    }

    public PhoneNumberVerificationCodeToken(Object principal, Object credentials, Collection<? extends GrantedAuthority> authorities) {
        super(authorities);
        this.principal = principal;
        this.credentials = credentials;
        super.setAuthenticated(true);
    }

    @Override
    public Object getCredentials() {
        return this.credentials;
    }

    @Override
    public Object getPrincipal() {
        return this.principal;
    }

    public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {
        Assert.isTrue(!isAuthenticated, "Cannot set this token to trusted - use constructor which takes a GrantedAuthority list instead");
        super.setAuthenticated(false);
    }

    public void eraseCredentials() {
        super.eraseCredentials();
        this.credentials = null;
    }

    public static PhoneNumberVerificationCodeToken unauthenticated(Object principal, Object credentials) {
        return new PhoneNumberVerificationCodeToken(principal, credentials);
    }

    public static PhoneNumberVerificationCodeToken authenticated(Object principal, Object credentials, Collection<? extends GrantedAuthority> authorities) {
        return new PhoneNumberVerificationCodeToken(principal, credentials, authorities);
    }
}
