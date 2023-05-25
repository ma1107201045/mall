package com.lingyi.mall.auth.admin.controller;

import cn.hutool.captcha.ICaptcha;
import com.lingyi.mall.auth.admin.properties.MaaCaptchaProperties;
import com.lingyi.mall.auth.admin.util.CaptchaUtil;
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
@Tag(name = "获取验证码", description = "获取验证码")
@Controller
@RequestMapping("/maa/captcha")
@RequiredArgsConstructor
public class MaaCaptchaController {

    private final MaaCaptchaProperties mabCaptchaProperties;

    @Operation(summary = "获取验证码", description = "获取验证码")
    @GetMapping
    public void get(HttpSession session, HttpServletResponse response) throws IOException {
        response.setContentType(MediaType.IMAGE_PNG_VALUE);
        ICaptcha captcha = CaptchaUtil.get(mabCaptchaProperties);
        session.setAttribute(mabCaptchaProperties.getSessionAttributeName(), captcha.getCode());
        OutputStream os = response.getOutputStream();
        captcha.write(os);
        os.close();
        os.flush();
    }

}
