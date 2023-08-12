package com.lingyi.mall.auth.app.service;

import com.lingyi.mall.auth.app.dto.AppLoginDTO;
import com.lingyi.mall.auth.app.dto.AppSendDTO;
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
     * @param appSendDTO 发送dto
     */
    void send(AppSendDTO appSendDTO);

    /**
     * 手机号登录
     *
     * @param appLoginDTO 登录DTO
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
