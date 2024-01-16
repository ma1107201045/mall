package com.lingyi.mall.auth.admin.service.impl;

import cn.hutool.captcha.AbstractCaptcha;
import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.generator.MathGenerator;
import cn.hutool.core.util.IdUtil;
import cn.hutool.crypto.SecureUtil;
import com.lingyi.mall.api.system.consumer.UserFeignConsumer;
import com.lingyi.mall.auth.admin.constant.AdminConstant;
import com.lingyi.mall.auth.admin.converter.AuthAdminConverter;
import com.lingyi.mall.auth.admin.enums.AdminFailEnum;
import com.lingyi.mall.auth.admin.model.dto.AuthenticatorDTO;
import com.lingyi.mall.auth.admin.model.vo.ImageCaptchaVO;
import com.lingyi.mall.auth.admin.model.vo.AuthenticatorVO;
import com.lingyi.mall.auth.admin.properties.ImageCaptchaProperties;
import com.lingyi.mall.auth.admin.properties.enums.CodeGeneratorType;
import com.lingyi.mall.auth.admin.service.AuthAdminService;
import com.lingyi.mall.auth.admin.util.AdminRedisKeyUtil;
import com.lingyi.mall.common.core.exception.BusinessException;
import com.lingyi.mall.common.core.util.AssertUtil;
import com.lingyi.mall.common.core.util.ConverterUtil;
import com.lingyi.mall.common.core.util.HttpUtil;
import com.lingyi.mall.common.redis.util.RedisUtil;
import com.lingyi.mall.auth.admin.util.CodeGeneratorProxy;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;

import java.io.IOException;
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
    public AuthenticatorVO login(AuthenticatorDTO authenticatorDTO) {
        //校验验证码是否过期
        var imageCaptcha = redisUtil.get(adminRedisKeyUtil.getImageCaptchaKey(authenticatorDTO.getUuid()), String.class);
        AssertUtil.notNull(imageCaptcha, AdminFailEnum.IMAGE_CAPTCHA_STALE_DATED_ERROR);
        //校验验证码是否错误
        var flag = imageCaptcha.equals(authenticatorDTO.getImageCaptcha());
        AssertUtil.isTrue(flag, AdminFailEnum.IMAGE_CAPTCHA_ERROR);
        //校验用户
        var userResponse = userFeignConsumer.getUserByUserName(authenticatorDTO.getUserName());
        AssertUtil.notNull(userResponse, AdminFailEnum.USER_NAME_NOT_EXIST_ERROR);
        //校验用户密码
        var encodedPassword = SecureUtil.md5(authenticatorDTO.getPassword());
        AssertUtil.isEquals(userResponse.getPassword(), encodedPassword, AdminFailEnum.PASSWORD_ERROR);
        return ConverterUtil.to(userResponse, AuthenticatorVO.class);
    }


    @Override
    public ImageCaptchaVO readImageCaptcha() {
        var uuid = IdUtil.fastUUID();
        var captcha = getImageCaptchaObject();
        setImageCaptcha(uuid, captcha);
        var base64ImageCaptcha = captcha.getImageBase64Data();
        return AuthAdminConverter.INSTANCE.of(uuid, base64ImageCaptcha);
    }

    @Override
    public void writeImageCaptcha() {
        var uuid = IdUtil.fastUUID();
        var abstractCaptcha = getImageCaptchaObject();
        setImageCaptcha(uuid, abstractCaptcha);
        var response = HttpUtil.getResponse();
        assert response != null;
        response.setContentType(MediaType.IMAGE_PNG_VALUE);
        response.setHeader(AdminConstant.UUID, uuid);
        try (var os = response.getOutputStream()) {
            abstractCaptcha.write(os);
        } catch (IOException e) {
            log.error("write image captcha error");
        }
    }


    private AbstractCaptcha getImageCaptchaObject() {
        AbstractCaptcha captcha;
        switch (properties.getDisturbanceType()) {
            case LINE ->
                    captcha = CaptchaUtil.createLineCaptcha(properties.getWidth(), properties.getHeight(), properties.getCount(), properties.getTypeCount());
            case CIRCLE ->
                    captcha = CaptchaUtil.createCircleCaptcha(properties.getWidth(), properties.getHeight(), properties.getCount(), properties.getTypeCount());
            case SHEAR ->
                    captcha = CaptchaUtil.createShearCaptcha(properties.getWidth(), properties.getHeight(), properties.getCount(), properties.getTypeCount());
            case GIF ->
                    captcha = CaptchaUtil.createGifCaptcha(properties.getWidth(), properties.getHeight(), properties.getCount());
            default -> throw new BusinessException(AdminFailEnum.GET_IMAGE_CAPTCHA_ERROR);
        }
        if (properties.getCodeGeneratorType() == CodeGeneratorType.MATH) {
            captcha.setGenerator(new CodeGeneratorProxy(new MathGenerator(1)));
        }
        return captcha;
    }

    private void setImageCaptcha(String uuid, AbstractCaptcha captcha) {
        var imageCaptcha = captcha.getCode();
        if (captcha.getGenerator() instanceof CodeGeneratorProxy) {
            var firstNumber = Integer.parseInt(imageCaptcha.substring(0, 1));
            var operator = imageCaptcha.substring(1, 2);
            var secondNumber = Integer.parseInt(imageCaptcha.substring(2, 3));
            switch (operator) {
                case "+" -> imageCaptcha = String.valueOf(firstNumber + secondNumber);
                case "-" -> imageCaptcha = String.valueOf(firstNumber - secondNumber);
                case "*" -> imageCaptcha = String.valueOf(firstNumber * secondNumber);
                default -> throw new BusinessException(AdminFailEnum.SET_IMAGE_CAPTCHA_ERROR);
            }
        }
        redisUtil.set(adminRedisKeyUtil.getImageCaptchaKey(uuid), imageCaptcha, 5L, TimeUnit.MINUTES);
    }

}
