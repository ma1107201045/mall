package com.lingyi.mall.auth.app.service;

import com.lingyi.mall.auth.app.model.dto.AuthAppEmailLoginDTO;
import com.lingyi.mall.auth.app.model.dto.AuthAppSmsLoginDTO;
import com.lingyi.mall.auth.app.model.dto.AuthAppSendDTO;
import com.lingyi.mall.auth.app.model.vo.AuthAppLoginVO;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/5/25 15:50
 * @description
 */
public interface AuthAppService {

    /**
     * 发送验证码（手机或者邮箱）
     *
     * @param authAppSendDTO 发送dto
     */
    void sendCaptcha(AuthAppSendDTO authAppSendDTO);


    /**
     * 短信登录
     *
     * @param authAppSmsLoginDTO 短信登录DTO
     * @return AppLoginVO
     */
    AuthAppLoginVO smsLogin(AuthAppSmsLoginDTO authAppSmsLoginDTO);


    /**
     * 邮箱登录
     *
     * @param authAppEmailLoginDTO 邮箱登录DTO
     * @return AppLoginVO
     */
    AuthAppLoginVO emailLogin(AuthAppEmailLoginDTO authAppEmailLoginDTO);


    /**
     * 注销
     */
    void logout();
}
