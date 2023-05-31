package com.lingyi.mall.common.base.entity;

import org.springframework.security.core.GrantedAuthority;

import java.io.Serializable;
import java.util.Collection;

/**
 * @Author: maweiyan
 * @Email 1107201045@qq.com
 * @DateTime: 2023/5/27 1:26
 * @Description:
 */
public interface MemberDetails extends Serializable {

    /**
     * 获取权限
     *
     * @return Collection
     */
    Collection<? extends GrantedAuthority> getAuthorities();

    /**
     * 获取手机号
     *
     * @return String
     */

    String getPhoneNumber();

    /**
     * 获取验证码
     *
     * @return String
     */
    String getVerificationCode();

    /**
     * 获取账户状态
     *
     * @return boolean
     */
    boolean isEnabled();

}
