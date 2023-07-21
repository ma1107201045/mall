package com.lingyi.mall.auth.app.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.RandomUtil;
import cn.hutool.jwt.JWTUtil;
import com.lingyi.mall.api.member.consumer.MemberFeignConsumer;
import com.lingyi.mall.api.member.consumer.MemberLevelFeignConsumer;
import com.lingyi.mall.api.member.dto.MemberReqDTO;
import com.lingyi.mall.api.member.dto.MemberRespDTO;
import com.lingyi.mall.api.sms.consumer.CaptchaFeignConsumer;
import com.lingyi.mall.api.sms.dto.CaptchaSendReqDTO;
import com.lingyi.mall.api.sms.dto.CaptchaVerifyReqDTO;
import com.lingyi.mall.api.sms.enums.BusinessTypeEnum;
import com.lingyi.mall.api.sms.enums.ServiceTypeEnum;
import com.lingyi.mall.auth.app.dto.AppLoginDTO;
import com.lingyi.mall.auth.app.enums.AppFailEnum;
import com.lingyi.mall.auth.app.enums.RegisterSourceEnum;
import com.lingyi.mall.auth.app.properties.SmsCaptchaProperties;
import com.lingyi.mall.auth.app.service.AppService;
import com.lingyi.mall.auth.app.util.UserNameUtil;
import com.lingyi.mall.auth.app.vo.AppLoginVO;
import com.lingyi.mall.common.base.constant.BaseConstant;
import com.lingyi.mall.common.base.enums.WhetherEnum;
import com.lingyi.mall.common.base.util.AssertUtil;
import com.lingyi.mall.common.base.util.ConverterUtil;
import com.lingyi.mall.common.base.util.SnowFlakeIdUtil;
import com.lingyi.mall.common.security.app.constant.SecurityConstant;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
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
            Long memberLevelId = memberLevelFeignConsumer.getDefaultLevelId();
            AssertUtil.notNull(memberLevelId, AppFailEnum.MEMBER_DEFAULT_LEVEL_ID_NULL_ERROR);
            MemberReqDTO memberReqDTO = new MemberReqDTO();
            memberReqDTO.setMemberLevelId(memberLevelId);
            memberReqDTO.setUserName(UserNameUtil.getRightFourBit(phoneNumber));
            memberReqDTO.setUserName(SnowFlakeIdUtil.nextStr());
            memberReqDTO.setNickname(UserNameUtil.getRightFourBit(phoneNumber));
            memberReqDTO.setPhoneNumber(phoneNumber);
            memberReqDTO.setIsEnable(WhetherEnum.Y.getCode());
            memberReqDTO.setRegisterSource(RegisterSourceEnum.H5.getCode());
            memberReqDTO.setRegisterDataTime(LocalDateTime.now());
            memberFeignConsumer.register(memberReqDTO);
            memberRespDTO = ConverterUtil.to(memberReqDTO, MemberRespDTO.class);
        }
        //生成token
        String token = JWTUtil.createToken(BeanUtil.beanToMap(memberRespDTO), SecurityConstant.JWT_KEY.getBytes(StandardCharsets.UTF_8));
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
