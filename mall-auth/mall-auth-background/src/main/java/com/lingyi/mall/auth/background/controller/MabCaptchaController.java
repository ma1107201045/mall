package com.lingyi.mall.auth.background.controller;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.CircleCaptcha;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.io.OutputStream;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/5/1 17:53
 * @description 用户认证controller
 */
@Tag(name = "后台【认证服务-验证码】", description = "后台【认证服务-验证码】")
@Controller
@RequestMapping("/mab/captcha")
@RequiredArgsConstructor
public class MabCaptchaController {


    @Operation(summary = "获取验证码", description = "获取验证码")
    @GetMapping
    public void get(HttpSession session, HttpServletResponse response) throws IOException {
        response.setContentType(MediaType.IMAGE_PNG_VALUE);
        CircleCaptcha circleCaptcha = CaptchaUtil.createCircleCaptcha(150, 50, 4, 5);
        session.setAttribute("captcha", circleCaptcha.getCode());
        OutputStream os = response.getOutputStream();
        circleCaptcha.write(os);
        os.close();
        os.flush();
    }

}
