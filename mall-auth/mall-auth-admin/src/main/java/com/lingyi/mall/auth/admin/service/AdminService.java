package com.lingyi.mall.auth.admin.service;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/6/29 8:51
 * @description
 */
public interface AdminService {


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
