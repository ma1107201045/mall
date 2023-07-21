package com.lingyi.mall.auth.app.converter;

import cn.hutool.core.util.RandomUtil;
import com.lingyi.mall.api.member.dto.MemberReqDTO;
import com.lingyi.mall.api.sms.dto.CaptchaSendReqDTO;
import com.lingyi.mall.api.sms.dto.CaptchaVerifyReqDTO;
import com.lingyi.mall.api.sms.enums.BusinessTypeEnum;
import com.lingyi.mall.api.sms.enums.ServiceTypeEnum;
import com.lingyi.mall.auth.app.dto.AppLoginDTO;
import com.lingyi.mall.auth.app.enums.RegisterSourceEnum;
import com.lingyi.mall.auth.app.properties.SmsCaptchaProperties;
import com.lingyi.mall.auth.app.util.UserNameUtil;
import com.lingyi.mall.common.base.constant.BaseConstant;
import com.lingyi.mall.common.base.enums.WhetherEnum;
import com.lingyi.mall.common.base.util.SnowFlakeIdUtil;

import java.time.LocalDateTime;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/7/21 10:34
 * @description
 */
public class AppConverter {

    public static final AppConverter INSTANCE = new AppConverter();

    private AppConverter() {

    }

    public CaptchaVerifyReqDTO to(AppLoginDTO appLoginDTO, SmsCaptchaProperties properties) {
        String phoneNumber = appLoginDTO.getPhoneNumber();
        CaptchaVerifyReqDTO captchaVerifyReqDTO = new CaptchaVerifyReqDTO();
        captchaVerifyReqDTO.setPhoneNumber(phoneNumber);
        captchaVerifyReqDTO.setServiceType(properties.getServiceTypeEnum().getCode());
        captchaVerifyReqDTO.setBusinessType(properties.getBusinessTypeEnum().getCode());
        captchaVerifyReqDTO.setCaptcha(appLoginDTO.getSmsCaptcha());
        return captchaVerifyReqDTO;
    }

    public MemberReqDTO to(AppLoginDTO appLoginDTO, Long memberLevelId) {
        MemberReqDTO memberReqDTO = new MemberReqDTO();
        memberReqDTO.setMemberLevelId(memberLevelId);
        memberReqDTO.setUserName(SnowFlakeIdUtil.nextStr());
        memberReqDTO.setNickname(UserNameUtil.getRightFourBit(appLoginDTO.getPhoneNumber()));
        memberReqDTO.setPhoneNumber(appLoginDTO.getPhoneNumber());
        memberReqDTO.setIsEnable(WhetherEnum.Y.getCode());
        memberReqDTO.setRegisterSource(RegisterSourceEnum.H5.getCode());
        memberReqDTO.setRegisterDataTime(LocalDateTime.now());
        return memberReqDTO;
    }

    public CaptchaSendReqDTO to(String phoneNumber, SmsCaptchaProperties properties) {
        CaptchaSendReqDTO captchaSendReqDTO = new CaptchaSendReqDTO();
        captchaSendReqDTO.setServiceType(properties.getServiceTypeEnum().getCode());
        captchaSendReqDTO.setBusinessType(properties.getBusinessTypeEnum().getCode());
        captchaSendReqDTO.setPhoneNumber(phoneNumber);
        captchaSendReqDTO.setCaptcha(RandomUtil.randomNumbers(properties.getLength()));
        captchaSendReqDTO.setLength(properties.getLength());
        captchaSendReqDTO.setExpiryDate(properties.getExpiryDate());
        captchaSendReqDTO.setIntervalDate(properties.getIntervalDate());
        captchaSendReqDTO.setUpperLimit(properties.getUpperLimit());
        captchaSendReqDTO.setRemark(ServiceTypeEnum.MALL_AUTH_APP.getMessage() + BaseConstant.COLON_CHAR + BusinessTypeEnum.LOGIN.getMessage());
        return captchaSendReqDTO;
    }
}
