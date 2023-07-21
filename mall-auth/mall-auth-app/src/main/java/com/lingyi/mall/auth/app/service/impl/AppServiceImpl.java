package com.lingyi.mall.auth.app.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.jwt.JWTUtil;
import com.lingyi.mall.api.member.consumer.MemberFeignConsumer;
import com.lingyi.mall.api.member.consumer.MemberLevelFeignConsumer;
import com.lingyi.mall.api.member.dto.MemberReqDTO;
import com.lingyi.mall.api.member.dto.MemberRespDTO;
import com.lingyi.mall.api.sms.consumer.CaptchaFeignConsumer;
import com.lingyi.mall.api.sms.dto.CaptchaSendReqDTO;
import com.lingyi.mall.api.sms.dto.CaptchaVerifyReqDTO;
import com.lingyi.mall.auth.app.converter.AppConverter;
import com.lingyi.mall.auth.app.dto.AppLoginDTO;
import com.lingyi.mall.auth.app.enums.AppFailEnum;
import com.lingyi.mall.auth.app.properties.SmsCaptchaProperties;
import com.lingyi.mall.auth.app.service.AppService;
import com.lingyi.mall.auth.app.vo.AppLoginVO;
import com.lingyi.mall.common.base.util.AssertUtil;
import com.lingyi.mall.common.base.util.ConverterUtil;
import com.lingyi.mall.common.security.app.constant.SecurityConstant;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.util.Objects;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/5/25 15:50
 * @description
 */
@Service
@RequiredArgsConstructor
public class AppServiceImpl implements AppService {

    private final MemberFeignConsumer memberFeignConsumer;

    private final MemberLevelFeignConsumer memberLevelFeignConsumer;

    private final CaptchaFeignConsumer captchaFeignConsumer;

    private final SmsCaptchaProperties properties;

    @Override
    public AppLoginVO login(AppLoginDTO appLoginDTO) {
        //转换数据并且校验短信验证码
        CaptchaVerifyReqDTO captchaVerifyReqDTO = AppConverter.INSTANCE.to(appLoginDTO, properties);
        captchaFeignConsumer.verify(captchaVerifyReqDTO);

        //通过手机号校验用户是否存在，不存在注册
        MemberRespDTO memberRespDTO = memberFeignConsumer.getByPhoneNumber(appLoginDTO.getPhoneNumber());
        if (Objects.isNull(memberRespDTO)) {
            Long memberLevelId = memberLevelFeignConsumer.getDefaultLevelId();
            AssertUtil.notNull(memberLevelId, AppFailEnum.MEMBER_DEFAULT_LEVEL_ID_NULL_ERROR);

            MemberReqDTO memberReqDTO = AppConverter.INSTANCE.to(appLoginDTO, memberLevelId);
            memberRespDTO = ConverterUtil.to(memberReqDTO, MemberRespDTO.class);
            memberFeignConsumer.register(memberReqDTO);
        }

        //通过会员信息生成token
        String token = JWTUtil.createToken(BeanUtil.beanToMap(memberRespDTO), SecurityConstant.JWT_KEY.getBytes(StandardCharsets.UTF_8));
        AppLoginVO appLoginVO = ConverterUtil.to(memberRespDTO, AppLoginVO.class);
        appLoginVO.setAuthorization(token);
        return appLoginVO;
    }


    @Override
    public void sendSmsCaptcha(String phoneNumber) {
        CaptchaSendReqDTO captchaSendReqDTO = AppConverter.INSTANCE.to(phoneNumber, properties);
        captchaFeignConsumer.send(captchaSendReqDTO);
    }
}
