package com.lingyi.mall.auth.app.converter;

import cn.hutool.core.util.RandomUtil;
import cn.hutool.core.util.StrUtil;
import com.lingyi.mall.api.member.dto.LoginLogReqDTO;
import com.lingyi.mall.api.member.dto.MemberReqDTO;
import com.lingyi.mall.api.member.dto.MemberRespDTO;
import com.lingyi.mall.api.info.dto.InfoCaptchaSendReqDTO;
import com.lingyi.mall.api.info.dto.InfoCaptchaVerifyReqDTO;
import com.lingyi.mall.api.info.enums.InfoBusinessEnum;
import com.lingyi.mall.api.info.enums.InfoServiceEnum;
import com.lingyi.mall.auth.app.model.dto.AuthAppLoginDTO;
import com.lingyi.mall.auth.app.enums.RegisterSourceEnum;
import com.lingyi.mall.auth.app.properties.SmsCaptchaProperties;
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

    public InfoCaptchaSendReqDTO to(String phoneNumber, SmsCaptchaProperties properties) {
        var captchaSendReqDTO = new InfoCaptchaSendReqDTO();
        captchaSendReqDTO.setServiceType(properties.getService().getCode());
        captchaSendReqDTO.setBusinessType(properties.getBusiness().getCode());
        captchaSendReqDTO.setType(properties.getType().getCode());
        captchaSendReqDTO.setNumber(phoneNumber);
        captchaSendReqDTO.setIntervalTime(properties.getIntervalTime());
        captchaSendReqDTO.setUpperLimit(properties.getUpperLimit());
        captchaSendReqDTO.setCaptcha(RandomUtil.randomNumbers(properties.getCaptchaLength()));
        captchaSendReqDTO.setCaptchaLength(properties.getCaptchaLength());
        captchaSendReqDTO.setCaptchaExpiryDate(properties.getCaptchaExpiryDate());
        captchaSendReqDTO.setRemark(InfoServiceEnum.MALL_AUTH_APP.getMessage() + BaseConstant.COLON_CHAR + InfoBusinessEnum.LOGIN.getMessage());
        return captchaSendReqDTO;
    }

    public InfoCaptchaVerifyReqDTO to(AuthAppLoginDTO authAppLoginDTO, SmsCaptchaProperties properties) {
        var phoneNumber = authAppLoginDTO.getPhoneNumber();
        InfoCaptchaVerifyReqDTO captchaVerifyReqDTO = new InfoCaptchaVerifyReqDTO();
        captchaVerifyReqDTO.setNumber(phoneNumber);
        captchaVerifyReqDTO.setServiceType(properties.getService().getCode());
        captchaVerifyReqDTO.setBusinessType(properties.getBusiness().getCode());
        captchaVerifyReqDTO.setCaptcha(authAppLoginDTO.getSmsCaptcha());
        return captchaVerifyReqDTO;
    }

    public MemberReqDTO to(AuthAppLoginDTO authAppLoginDTO, Long memberLevelId) {
        var memberReqDTO = new MemberReqDTO();
        memberReqDTO.setMemberLevelId(memberLevelId);
        memberReqDTO.setNickname(UserNameUtil.getRightFourBit(authAppLoginDTO.getPhoneNumber()));
        memberReqDTO.setPhoneNumber(authAppLoginDTO.getPhoneNumber());
        memberReqDTO.setIsEnable(WhetherEnum.Y.getCode());
        memberReqDTO.setRegisterSource(RegisterSourceEnum.H5.getCode());
        memberReqDTO.setRegisterDataTime(LocalDateTime.now());
        return memberReqDTO;
    }

    public LoginLogReqDTO to(MemberRespDTO memberRespDTO) {
        var memberLoginLogReqDTO = new LoginLogReqDTO();
        memberLoginLogReqDTO.setMemberId(memberRespDTO.getId());
        memberLoginLogReqDTO.setMemberUserName(memberRespDTO.getUserName());
        memberLoginLogReqDTO.setIp(StrUtil.EMPTY);
        memberLoginLogReqDTO.setCity(StrUtil.EMPTY);
        memberLoginLogReqDTO.setCreateDataTime(LocalDateTime.now());
        return memberLoginLogReqDTO;
    }


}
