package com.lingyi.mall.common.security.app.authentication;

import com.lingyi.mall.common.security.app.authentication.entity.MemberDetails;
import com.lingyi.mall.common.security.app.authentication.service.MemberDetailsService;
import com.lingyi.mall.common.security.app.authentication.token.PhoneNumberVerificationCodeToken;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.SpringSecurityMessageSource;
import org.springframework.security.core.authority.mapping.GrantedAuthoritiesMapper;
import org.springframework.security.core.authority.mapping.NullAuthoritiesMapper;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * @Author: maweiyan
 * @Email 1107201045@qq.com
 * @DateTime: 2023/5/27 1:12
 * @Description:
 */
public class DaoAuthenticationProvider implements AuthenticationProvider {
    protected MessageSourceAccessor messages = SpringSecurityMessageSource.getAccessor();
    private MemberDetailsService memberDetailsService;
    private GrantedAuthoritiesMapper authoritiesMapper = new NullAuthoritiesMapper();

    public DaoAuthenticationProvider(MemberDetailsService memberDetailsService) {
        this.memberDetailsService = memberDetailsService;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        MemberDetails memberDetails;
        try {
            memberDetails = this.memberDetailsService.loadMemberByPhoneNumber((String) authentication.getPrincipal());
        } catch (UsernameNotFoundException var6) {
            throw new BadCredentialsException(this.messages.getMessage("AbstractUserDetailsAuthenticationProvider.badCredentials", "Bad credentials"));
        }
        //校验验证码

        //校验账户状态
        if (!memberDetails.isEnabled()) {
            throw new DisabledException(DaoAuthenticationProvider.this.messages.getMessage("AbstractUserDetailsAuthenticationProvider.disabled", "User is disabled"));
        }
        return this.createSuccessAuthentication(memberDetails, authentication, memberDetails);
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return PhoneNumberVerificationCodeToken.class.isAssignableFrom(authentication);
    }


    protected Authentication createSuccessAuthentication(Object principal, Authentication authentication, MemberDetails memberDetails) {
        PhoneNumberVerificationCodeToken result = PhoneNumberVerificationCodeToken.authenticated(principal, authentication.getCredentials(), this.authoritiesMapper.mapAuthorities(memberDetails.getAuthorities()));
        result.setDetails(authentication.getDetails());
        return result;
    }


    public void setMemberDetailsService(MemberDetailsService memberDetailsService) {
        this.memberDetailsService = memberDetailsService;
    }

    protected MemberDetailsService getMemberDetailsService() {
        return this.memberDetailsService;
    }

    public void setAuthoritiesMapper(GrantedAuthoritiesMapper authoritiesMapper) {
        this.authoritiesMapper = authoritiesMapper;
    }
}
