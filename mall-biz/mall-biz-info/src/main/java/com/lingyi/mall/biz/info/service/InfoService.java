package com.lingyi.mall.biz.info.service;

import com.lingyi.mall.api.info.request.InfoCaptchaSendRequest;
import com.lingyi.mall.api.info.request.InfoCaptchaVerifyRequest;
import com.lingyi.mall.api.info.request.InfoRequest;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/7/12 14:22
 * @description
 */
public interface InfoService {

    /**
     * 发送
     *
     * @param smsReqDTO 。。
     */
    void send(InfoRequest smsReqDTO);

    /**
     * 发送验证码
     *
     * @param smsCaptchaSendReqDTO ，，
     */
    void sendCaptcha(InfoCaptchaSendRequest smsCaptchaSendReqDTO);


    /**
     * 校验验证码
     *
     * @param smsCaptchaVerifyReqDTO 。。
     */
    void verifyCaptcha(InfoCaptchaVerifyRequest smsCaptchaVerifyReqDTO);


}
