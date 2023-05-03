package com.lingyi.mall.auth.background.service;

import com.lingyi.mall.auth.background.dto.UserAuthDTO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.net.HttpCookie;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/5/2 12:56
 * @description
 */
public interface UserService {


    /**
     * 登录
     *
     * @param userAuthDTO 用户登录DTO
     */
    void login(UserAuthDTO userAuthDTO) throws ServletException, IOException;


    /**
     * 注销
     *
     * @param httpSession httpsession
     */
    void logout(HttpSession httpSession);
}
