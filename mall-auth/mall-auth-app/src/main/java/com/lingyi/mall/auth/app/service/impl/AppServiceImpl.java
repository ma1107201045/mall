package com.lingyi.mall.auth.app.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.RandomUtil;
import cn.hutool.jwt.JWTUtil;
import com.lingyi.mall.api.member.consumer.MemberFeignConsumer;
import com.lingyi.mall.api.member.dto.MemberRespDTO;
import com.lingyi.mall.api.sms.consumer.CaptchaFeignConsumer;
import com.lingyi.mall.api.sms.dto.CaptchaSendReqDTO;
import com.lingyi.mall.api.sms.dto.CaptchaVerifyReqDTO;
import com.lingyi.mall.api.sms.enums.BusinessTypeEnum;
import com.lingyi.mall.api.sms.enums.ServiceTypeEnum;
import com.lingyi.mall.auth.app.constant.AppConstant;
import com.lingyi.mall.auth.app.dto.AppLoginDTO;
import com.lingyi.mall.auth.app.properties.SmsCaptchaProperties;
import com.lingyi.mall.auth.app.service.AppService;
import com.lingyi.mall.auth.app.vo.AppLoginVO;
import com.lingyi.mall.common.base.constant.BaseConstant;
import com.lingyi.mall.common.base.util.ConverterUtil;
import com.lingyi.mall.common.security.app.constant.SecurityAppConstant;
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

    private final CaptchaFeignConsumer captchaFeignConsumer;

    private final SmsCaptchaProperties smsCaptchaProperties;

    @Override
    public AppLoginVO login(AppLoginDTO appLoginDTO) {
        //设置数据
        String phoneNumber = appLoginDTO.getPhoneNumber();
        CaptchaVerifyReqDTO captchaVerifyReqDTO = new CaptchaVerifyReqDTO();
        captchaVerifyReqDTO.setPhoneNumber(phoneNumber);
        captchaVerifyReqDTO.setServiceType(smsCaptchaProperties.getServiceTypeEnum().getCode());
        captchaVerifyReqDTO.setBusinessType(smsCaptchaProperties.getBusinessTypeEnum().getCode());
        captchaVerifyReqDTO.setCaptcha(appLoginDTO.getSmsCaptcha());
        //校验验证码
        captchaFeignConsumer.verify(captchaVerifyReqDTO);
        //手机号查询用会员
        MemberRespDTO memberRespDTO = memberFeignConsumer.getByPhoneNumber(phoneNumber);
        if (Objects.isNull(memberRespDTO)) {
            memberFeignConsumer.save(phoneNumber);
            //TODO 待优化，默认值从这边生成
            memberRespDTO = memberFeignConsumer.getByPhoneNumber(phoneNumber);
        }
        //生成token
        String token = JWTUtil.createToken(BeanUtil.beanToMap(memberRespDTO), SecurityAppConstant.JWT_KEY.getBytes(StandardCharsets.UTF_8));
        AppLoginVO appLoginVO = ConverterUtil.to(memberRespDTO, AppLoginVO.class);
        appLoginVO.setAuthorization(token);
        return appLoginVO;
    }


    @Override
    public void sendSmsCaptcha(String phoneNumber) {
        CaptchaSendReqDTO captchaSendReqDTO = new CaptchaSendReqDTO();
        captchaSendReqDTO.setServiceType(smsCaptchaProperties.getServiceTypeEnum().getCode());
        captchaSendReqDTO.setBusinessType(smsCaptchaProperties.getBusinessTypeEnum().getCode());
        captchaSendReqDTO.setPhoneNumber(phoneNumber);
        captchaSendReqDTO.setCaptcha(RandomUtil.randomNumbers(smsCaptchaProperties.getLength()));
        captchaSendReqDTO.setLength(smsCaptchaProperties.getLength());
        captchaSendReqDTO.setExpiryDate(smsCaptchaProperties.getExpiryDate());
        captchaSendReqDTO.setIntervalDate(smsCaptchaProperties.getIntervalDate());
        captchaSendReqDTO.setUpperLimit(smsCaptchaProperties.getUpperLimit());
        captchaSendReqDTO.setRemark(ServiceTypeEnum.MALL_AUTH_APP.getMessage() + BaseConstant.COLON_CHAR + BusinessTypeEnum.LOGIN.getMessage());
        captchaFeignConsumer.send(captchaSendReqDTO);
    }
}
