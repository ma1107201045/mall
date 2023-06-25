package com.lingyi.mall.auth.admin.controller;

import cn.hutool.captcha.ICaptcha;
import com.lingyi.mall.common.base.aspect.Log;
import com.lingyi.mall.common.base.enums.OperationTypeEnum;
import com.lingyi.mall.common.security.admin.propertis.ImageCaptchaProperties;
import com.lingyi.mall.common.security.admin.util.ImageCaptchaUtil;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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
 * @description 验证码接口
 */
@Slf4j
@Tag(name = "验证码接口", description = "验证码接口")
@Controller
@RequestMapping("/auth/admin")
@RequiredArgsConstructor
public class AdminController {

    private final ImageCaptchaProperties properties;

    @Operation(summary = "获取验证码", description = "获取验证码")
    @GetMapping("/get-image-captcha")
    @Log(title = "获取验证码", operationType = OperationTypeEnum.READ, ignoreParam = true)
    public void getCaptcha(HttpServletResponse response, HttpSession session) throws IOException {
        log.info("获取验证码。。。。。。。。");
        response.setContentType(MediaType.IMAGE_PNG_VALUE);
        ICaptcha captcha = ImageCaptchaUtil.get(properties);
        session.setAttribute(properties.getSessionAttributeName(), captcha.getCode());
        OutputStream os = response.getOutputStream();
        captcha.write(os);
        os.flush();
        os.close();
    }

}
