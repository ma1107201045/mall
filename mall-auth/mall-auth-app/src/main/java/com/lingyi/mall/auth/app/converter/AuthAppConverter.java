package com.lingyi.mall.auth.app.converter;

import cn.hutool.core.util.RandomUtil;
import cn.hutool.core.util.StrUtil;
import com.lingyi.mall.api.info.enums.InfoTypeEnum;
import com.lingyi.mall.api.member.reqeust.MemberLoginLogRequest;
import com.lingyi.mall.api.member.reqeust.MemberRequest;
import com.lingyi.mall.api.member.response.MemberResponse;
import com.lingyi.mall.api.info.request.InfoCaptchaSendRequest;
import com.lingyi.mall.api.info.request.InfoCaptchaVerifyRequest;
import com.lingyi.mall.api.info.enums.InfoBusinessEnum;
import com.lingyi.mall.api.info.enums.InfoServiceEnum;
import com.lingyi.mall.auth.app.model.dto.AuthAppSmsLoginDTO;
import com.lingyi.mall.auth.app.enums.RegisterSourceEnum;
import com.lingyi.mall.auth.app.properties.InfoCaptchaProperties;
import com.lingyi.mall.auth.app.util.UserNameUtil;
import com.lingyi.mall.common.core.constant.BaseConstant;
import com.lingyi.mall.common.core.enums.WhetherEnum;

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

    public InfoCaptchaSendRequest to(String number, InfoCaptchaProperties properties) {
        var infoCaptchaSendRequest = new InfoCaptchaSendRequest();
        infoCaptchaSendRequest.setServiceType(properties.getService().getCode());
        infoCaptchaSendRequest.setBusinessType(properties.getBusiness().getCode());
        infoCaptchaSendRequest.setType(properties.getType().getCode());
        infoCaptchaSendRequest.setNumber(number);
        infoCaptchaSendRequest.setIntervalTime(properties.getIntervalTime());
        infoCaptchaSendRequest.setUpperLimit(properties.getUpperLimit());
        infoCaptchaSendRequest.setCaptcha(RandomUtil.randomNumbers(properties.getCaptchaLength()));
        infoCaptchaSendRequest.setCaptchaLength(properties.getCaptchaLength());
        infoCaptchaSendRequest.setCaptchaExpiryDate(properties.getCaptchaExpiryDate());
        infoCaptchaSendRequest.setRemark(InfoServiceEnum.MALL_AUTH_APP.getMessage() + BaseConstant.COLON_CHAR + InfoBusinessEnum.LOGIN.getMessage());
        return infoCaptchaSendRequest;
    }

    public InfoCaptchaVerifyRequest to(AuthAppSmsLoginDTO authAppSmsLoginDTO, InfoCaptchaProperties properties) {
        var phoneNumber = authAppSmsLoginDTO.getPhoneNumber();
        var infoCaptchaVerifyRequest = new InfoCaptchaVerifyRequest();
        infoCaptchaVerifyRequest.setNumber(phoneNumber);
        infoCaptchaVerifyRequest.setServiceType(properties.getService().getCode());
        infoCaptchaVerifyRequest.setBusinessType(properties.getBusiness().getCode());
        infoCaptchaVerifyRequest.setCaptcha(authAppSmsLoginDTO.getSmsCaptcha());
        infoCaptchaVerifyRequest.setType(InfoTypeEnum.SMS_CAPTCHA.getCode());
        return infoCaptchaVerifyRequest;
    }

    public MemberRequest to(AuthAppSmsLoginDTO authAppSmsLoginDTO, Long memberLevelId) {
        var memberReqDTO = new MemberRequest();
        memberReqDTO.setMemberLevelId(memberLevelId);
        memberReqDTO.setNickname(UserNameUtil.getRightFourBit(authAppSmsLoginDTO.getPhoneNumber()));
        memberReqDTO.setPhoneNumber(authAppSmsLoginDTO.getPhoneNumber());
        memberReqDTO.setIsEnable(WhetherEnum.Y.getCode());
        memberReqDTO.setRegisterSource(RegisterSourceEnum.H5.getCode());
        memberReqDTO.setRegisterDataTime(LocalDateTime.now());
        return memberReqDTO;
    }

    public MemberLoginLogRequest to(MemberResponse memberResponse) {
        var memberLoginLogReqDTO = new MemberLoginLogRequest();
        memberLoginLogReqDTO.setMemberId(memberResponse.getId());
        memberLoginLogReqDTO.setMemberUserName(memberResponse.getUserName());
        memberLoginLogReqDTO.setIp(StrUtil.EMPTY);
        memberLoginLogReqDTO.setCity(StrUtil.EMPTY);
        memberLoginLogReqDTO.setCreateDataTime(LocalDateTime.now());
        return memberLoginLogReqDTO;
    }


}
