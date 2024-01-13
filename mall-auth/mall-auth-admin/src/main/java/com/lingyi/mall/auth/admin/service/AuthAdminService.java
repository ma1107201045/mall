package com.lingyi.mall.auth.admin.service;

import com.lingyi.mall.auth.admin.model.dto.LoginDTO;
import com.lingyi.mall.auth.admin.model.vo.ImageCaptchaVO;
import com.lingyi.mall.auth.admin.model.vo.LoginVO;
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
     *
     * @param loginDTO 认证信息
     * @return 认证信息
     */
    LoginVO login(LoginDTO loginDTO);

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


}
