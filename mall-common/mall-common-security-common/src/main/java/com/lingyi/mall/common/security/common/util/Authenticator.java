package com.lingyi.mall.common.security.common.util;

/**
 * @Author: maweiyan
 * @Email 1107201045@qq.com
 * @DateTime: 2023/7/22 23:32
 * @Description:
 */
public interface Authenticator {


    /**
     * 获取当前认证用户id
     *
     * @return 用户id
     */
    Long getUserId();

    /**
     * 获取当前认证名用户名称
     *
     * @return 用户名称
     */
    String getUserName();

    /**
     * 获取当前认证名手机号
     *
     * @return 手机号
     */
    String getPhoneNumber();

}
