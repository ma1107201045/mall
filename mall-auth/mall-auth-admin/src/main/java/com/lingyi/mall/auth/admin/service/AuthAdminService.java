package com.lingyi.mall.auth.admin.service;

import com.lingyi.mall.auth.admin.model.dto.AuthAdminDTO;
import com.lingyi.mall.auth.admin.model.vo.AuthAdminVO;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/6/29 8:51
 * @description
 */
public interface AuthAdminService {

    /**
     * 登录
     * @param authAdminDTO 认证信息
     * @return 认证信息
     */
    AuthAdminVO login(AuthAdminDTO authAdminDTO);


    /**
     * 读取图形验证码
     *
     * @param session session
     * @return BASE64数据
     */
    String readImageCaptcha(HttpSession session);

    /**
     * 输出图形验证码
     *
     * @param session  session
     * @param response 返回信息
     */
    void writeImageCaptcha(HttpSession session, HttpServletResponse response);


}
