package com.lingyi.mall.auth.app.service;

import com.lingyi.mall.auth.app.dto.AppLoginDTO;
import com.lingyi.mall.auth.app.vo.AppLoginVO;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/5/25 15:50
 * @description
 */
public interface AppService {

    /**
     * 发送短信验证码
     *
     * @param phoneNumber 手机号
     */
    void sendSmsCaptcha(String phoneNumber);

    /**
     * 登录（手机号登录）
     *
     * @param appLoginDTO 登录
     * @return AppLoginVO
     */
    AppLoginVO login(AppLoginDTO appLoginDTO);


    /**
     * 注销
     *
     * @param token 令牌
     */
    void logout(String token);
}
