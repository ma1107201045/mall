package com.lingyi.mall.auth.admin.service;

import com.lingyi.mall.auth.admin.model.dto.AuthAdminDTO;
import com.lingyi.mall.auth.admin.model.vo.AuthAdminVO;

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
     * @param authAdminDTO 认证信息
     * @return 认证信息
     */
    AuthAdminVO login(AuthAdminDTO authAdminDTO);

    /**
     * 读取图形验证码
     *
     * @return BASE64数据
     */
    String readImageCaptcha();

    /**
     * 输出图形验证码
     */
    void writeImageCaptcha();


    /**
     * 注销
     */
    void logout();


}
