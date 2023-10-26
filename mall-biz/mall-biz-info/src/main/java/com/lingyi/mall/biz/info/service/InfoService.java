package com.lingyi.mall.biz.info.service;

import com.lingyi.mall.api.info.dto.InfoCaptchaSendReqDTO;
import com.lingyi.mall.api.info.dto.InfoCaptchaVerifyReqDTO;
import com.lingyi.mall.api.info.dto.InfoReqDTO;

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
    void send(InfoReqDTO smsReqDTO);

    /**
     * 发送验证码
     *
     * @param smsCaptchaSendReqDTO ，，
     */
    void sendCaptcha(InfoCaptchaSendReqDTO smsCaptchaSendReqDTO);


    /**
     * 校验验证码
     *
     * @param smsCaptchaVerifyReqDTO 。。
     */
    void verifyCaptcha(InfoCaptchaVerifyReqDTO smsCaptchaVerifyReqDTO);


}