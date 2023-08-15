package com.lingyi.mall.auth.app.converter;

import cn.hutool.core.util.RandomUtil;
import com.lingyi.mall.api.member.dto.MemberReqDTO;
import com.lingyi.mall.api.sms.dto.CaptchaSendReqDTO;
import com.lingyi.mall.api.sms.dto.CaptchaVerifyReqDTO;
import com.lingyi.mall.api.sms.enums.BusinessTypeEnum;
import com.lingyi.mall.api.sms.enums.ServiceTypeEnum;
import com.lingyi.mall.auth.app.dto.AuthAppLoginDTO;
import com.lingyi.mall.auth.app.enums.RegisterSourceEnum;
import com.lingyi.mall.auth.app.properties.SmsCaptchaProperties;
import com.lingyi.mall.auth.app.util.UserNameUtil;
import com.lingyi.mall.common.base.constant.BaseConstant;
import com.lingyi.mall.common.base.enums.WhetherEnum;

import java.time.LocalDateTime;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/7/21 10:34
 * @description
 */
public class AuthAppConverter {

    public static final AuthAppConverter INSTANCE = new AuthAppConverter();

    private AuthAppConverter() {

    }

    public CaptchaVerifyReqDTO to(AuthAppLoginDTO authAppLoginDTO, SmsCaptchaProperties properties) {
        String phoneNumber = authAppLoginDTO.getPhoneNumber();
        CaptchaVerifyReqDTO captchaVerifyReqDTO = new CaptchaVerifyReqDTO();
        captchaVerifyReqDTO.setPhoneNumber(phoneNumber);
        captchaVerifyReqDTO.setServiceType(properties.getServiceTypeEnum().getCode());
        captchaVerifyReqDTO.setBusinessType(properties.getBusinessTypeEnum().getCode());
        captchaVerifyReqDTO.setCaptcha(authAppLoginDTO.getSmsCaptcha());
        return captchaVerifyReqDTO;
    }

    public MemberReqDTO to(AuthAppLoginDTO authAppLoginDTO, Long memberLevelId) {
        MemberReqDTO memberReqDTO = new MemberReqDTO();
        memberReqDTO.setMemberLevelId(memberLevelId);
        memberReqDTO.setNickname(UserNameUtil.getRightFourBit(authAppLoginDTO.getPhoneNumber()));
        memberReqDTO.setPhoneNumber(authAppLoginDTO.getPhoneNumber());
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
