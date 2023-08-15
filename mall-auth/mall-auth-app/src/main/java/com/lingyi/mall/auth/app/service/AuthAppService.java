package com.lingyi.mall.auth.app.service;

import com.lingyi.mall.auth.app.dto.AuthAppLoginDTO;
import com.lingyi.mall.auth.app.dto.AuthAppSendDTO;
import com.lingyi.mall.auth.app.vo.AuthAppLoginVO;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/5/25 15:50
 * @description
 */
public interface AuthAppService {

    /**
     * 发送短信验证码
     *
     * @param authAppSendDTO 发送dto
     */
    void send(AuthAppSendDTO authAppSendDTO);

    /**
     * 手机号登录
     *
     * @param authAppLoginDTO 登录DTO
     * @return AppLoginVO
     */
    AuthAppLoginVO login(AuthAppLoginDTO authAppLoginDTO);


    /**
     * 注销
     */
    void logout();
}
