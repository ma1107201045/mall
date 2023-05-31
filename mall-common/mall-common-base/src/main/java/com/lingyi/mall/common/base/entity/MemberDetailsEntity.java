package com.lingyi.mall.common.base.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

import java.io.Serial;
import java.time.LocalDateTime;
import java.util.Collection;

/**
 * @Author: maweiyan
 * @Email 1107201045@qq.com
 * @DateTime: 2023/5/27 10:38
 * @Description:
 */
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MemberDetailsEntity implements MemberDetails {
    @Serial
    private static final long serialVersionUID = -4555073638396468898L;

    private Collection<? extends GrantedAuthority> authorities;

    private String verificationCode;

    private String phoneNumber;

    private boolean enabled;

    private Long userId;

    private String userName;

    private LocalDateTime lastLoginDateTime;

    private String authorization;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    public String getVerificationCode() {
        return verificationCode;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }

    public Long getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public LocalDateTime getLastLoginDateTime() {
        return lastLoginDateTime;
    }

    public void setAuthorization(String authorization) {
        this.authorization = authorization;
    }

    public String getAuthorization() {
        return authorization;
    }


}
