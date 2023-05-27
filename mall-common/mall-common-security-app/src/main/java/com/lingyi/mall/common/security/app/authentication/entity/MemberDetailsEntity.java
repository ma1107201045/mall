package com.lingyi.mall.common.security.app.authentication.entity;

import com.lingyi.mall.common.security.app.authentication.entity.MemberDetails;
import lombok.Builder;
import org.springframework.security.core.GrantedAuthority;

import java.io.Serial;
import java.util.Collection;

/**
 * @Author: maweiyan
 * @Email 1107201045@qq.com
 * @DateTime: 2023/5/27 10:38
 * @Description:
 */
@Builder
public class MemberDetailsEntity implements MemberDetails {
    @Serial
    private static final long serialVersionUID = -4555073638396468898L;

    private Collection<? extends GrantedAuthority> authorities;

    private String verificationCode;

    private String phoneNumber;

    private boolean enabled;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPhoneNumber() {
        return verificationCode;
    }

    @Override
    public String getVerificationCode() {
        return verificationCode;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }
}
