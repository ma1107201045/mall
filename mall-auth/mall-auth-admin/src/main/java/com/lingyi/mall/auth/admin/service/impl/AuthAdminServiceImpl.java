package com.lingyi.mall.auth.admin.service.impl;

import cn.hutool.captcha.AbstractCaptcha;
import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.generator.MathGenerator;
import cn.hutool.core.util.IdUtil;
import cn.hutool.crypto.SecureUtil;
import com.lingyi.mall.api.system.consumer.UserFeignConsumer;
import com.lingyi.mall.auth.admin.constant.AdminConstant;
import com.lingyi.mall.auth.admin.enums.AdminFailEnum;
import com.lingyi.mall.auth.admin.model.dto.LoginDTO;
import com.lingyi.mall.auth.admin.model.vo.ImageCaptchaVO;
import com.lingyi.mall.auth.admin.model.vo.LoginVO;
import com.lingyi.mall.auth.admin.properties.ImageCaptchaProperties;
import com.lingyi.mall.auth.admin.properties.enums.CodeGeneratorType;
import com.lingyi.mall.auth.admin.service.AuthAdminService;
import com.lingyi.mall.auth.admin.util.AdminRedisKeyUtil;
import com.lingyi.mall.common.core.util.AssertUtil;
import com.lingyi.mall.common.core.util.ConverterUtil;
import com.lingyi.mall.common.core.util.HttpUtil;
import com.lingyi.mall.common.redis.util.RedisUtil;
import com.lingyi.mall.security.admin.util.CodeGeneratorProxy;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.OutputStream;
import java.util.concurrent.TimeUnit;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/6/29 8:51
 * @description
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class AuthAdminServiceImpl implements AuthAdminService {

    private final ImageCaptchaProperties properties;

    private final UserFeignConsumer userFeignConsumer;

    private final RedisUtil redisUtil;

    private final AdminRedisKeyUtil adminRedisKeyUtil;

    @Override
    public LoginVO login(LoginDTO loginDTO) {
        //校验验证码是否过期
        AbstractCaptcha abstractCaptcha = redisUtil.get(adminRedisKeyUtil.getImageCaptchaKey(loginDTO.getUuid()), AbstractCaptcha.class);
        AssertUtil.notNull(abstractCaptcha, AdminFailEnum.IMAGE_CAPTCHA_STALE_DATED_ERROR);
        //校验验证码是否错误
        boolean flag = abstractCaptcha.verify(loginDTO.getImageCaptcha());
        AssertUtil.isTrue(flag, AdminFailEnum.IMAGE_CAPTCHA_ERROR);
        //校验用户
        var userResponse = userFeignConsumer.getUserByUserName(loginDTO.getUserName());
        AssertUtil.notNull(userResponse, AdminFailEnum.USER_NAME_NOT_EXIST_ERROR);
        //校验用户密码
        var encodedPassword = SecureUtil.md5(loginDTO.getPassword());
        AssertUtil.isEquals(userResponse.getPassword(), encodedPassword, AdminFailEnum.PASSWORD_ERROR);
        return ConverterUtil.to(userResponse, LoginVO.class);
    }

    public static void main(String[] args) {
        System.out.println(SecureUtil.md5("199726ma."));
    }


    @Override
    public ImageCaptchaVO readImageCaptcha() {
        String uuid = IdUtil.fastUUID();
        AbstractCaptcha abstractCaptcha = getImageCaptchaObject();
        String base64ImageCaptcha = abstractCaptcha.getImageBase64Data();
        redisUtil.set(adminRedisKeyUtil.getImageCaptchaKey(uuid), abstractCaptcha, 5L, TimeUnit.MINUTES);
        ImageCaptchaVO imageCaptchaVO = new ImageCaptchaVO();
        imageCaptchaVO.setUuid(uuid);
        imageCaptchaVO.setBase64ImageCaptcha(base64ImageCaptcha);
        return imageCaptchaVO;
    }

    @Override
    public void writeImageCaptcha() {
        String uuid = IdUtil.fastUUID();
        AbstractCaptcha abstractCaptcha = getImageCaptchaObject();
        redisUtil.set(adminRedisKeyUtil.getImageCaptchaKey(uuid), abstractCaptcha, 5L, TimeUnit.MINUTES);
        var response = HttpUtil.getResponse();
        assert response != null;
        response.setContentType(MediaType.IMAGE_PNG_VALUE);
        response.setHeader(AdminConstant.UUID, uuid);
        try (OutputStream os = response.getOutputStream()) {
            abstractCaptcha.write(os);
        } catch (IOException e) {
            log.error("write image captcha error");
        }
    }


    private AbstractCaptcha getImageCaptchaObject() {
        AbstractCaptcha abstractCaptcha;
        switch (properties.getDisturbanceType()) {
            case LINE ->
                    abstractCaptcha = CaptchaUtil.createLineCaptcha(properties.getWidth(), properties.getHeight(), properties.getCount(), properties.getTypeCount());
            case CIRCLE ->
                    abstractCaptcha = CaptchaUtil.createCircleCaptcha(properties.getWidth(), properties.getHeight(), properties.getCount(), properties.getTypeCount());
            case SHEAR ->
                    abstractCaptcha = CaptchaUtil.createShearCaptcha(properties.getWidth(), properties.getHeight(), properties.getCount(), properties.getTypeCount());
            case GIF ->
                    abstractCaptcha = CaptchaUtil.createGifCaptcha(properties.getWidth(), properties.getHeight(), properties.getCount());
            default -> throw new RuntimeException("error");
        }
        if (properties.getCodeGeneratorType() == CodeGeneratorType.MATH) {
            abstractCaptcha.setGenerator(new CodeGeneratorProxy(new MathGenerator(1)));
        }
        return abstractCaptcha;
    }
}
