package com.lingyi.mall.biz.sms.service;

import com.lingyi.mall.api.sms.dto.CaptchaSendReqDTO;
import com.lingyi.mall.api.sms.dto.SmsAbstractReqDTO;

/**
 * @Author: maweiyan
 * @Email 1107201045@qq.com
 * @DateTime: 2023/10/15 4:03
 * @Description:
 */
public interface CaptchaService {


    /**
     * 发送
     *
     * @param captchaSendReqDTO 。。
     */

    void send(CaptchaSendReqDTO captchaSendReqDTO);


    /**
     * 校验
     *
     * @param captchaVerifyReqDTO 。。
     */
    void verify(SmsAbstractReqDTO captchaVerifyReqDTO);
}
