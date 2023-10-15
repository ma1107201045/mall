package com.lingyi.mall.biz.sms.service;

import com.lingyi.mall.api.sms.dto.CaptchaSendReqDTO;
import com.lingyi.mall.api.sms.dto.CaptchaVerifyReqDTO;
import com.lingyi.mall.api.sms.dto.SmsReqDTO;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/7/12 14:22
 * @description
 */
public interface SmsService {

    /**
     * 发送
     *
     * @param smsReqDTO 。。
     */
    void send(SmsReqDTO smsReqDTO);

    /**
     * 发送验证码
     *
     * @param captchaSendReqDTO ，，
     */
    void sendCaptcha(CaptchaSendReqDTO captchaSendReqDTO);


    /**
     * 校验验证码
     *
     * @param captchaVerifyDTO 。。
     */
    void verifyCaptcha(CaptchaVerifyReqDTO captchaVerifyDTO);


}