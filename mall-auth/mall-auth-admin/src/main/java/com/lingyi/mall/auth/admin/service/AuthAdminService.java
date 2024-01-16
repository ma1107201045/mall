package com.lingyi.mall.auth.admin.service;

import com.lingyi.mall.auth.admin.model.dto.AuthenticatorDTO;
import com.lingyi.mall.auth.admin.model.vo.ImageCaptchaVO;
import com.lingyi.mall.auth.admin.model.vo.AuthenticatorVO;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/6/29 8:51
 * @description
 */
public interface AuthAdminService {

    /**
     * 登录
     *
     * @param authenticatorDTO 认证信息
     * @return 认证信息
     */
    AuthenticatorVO login(AuthenticatorDTO authenticatorDTO);

    /**
     * 读取图形验证码
     *
     * @return BASE64数据
     */
    ImageCaptchaVO readImageCaptcha();

    /**
     * 输出图形验证码
     */
    void writeImageCaptcha();


    /**
     * 注销
     */
    void logout();


}
