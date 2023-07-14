package com.lingyi.mall.biz.sms.service;

import com.lingyi.mall.api.sms.dto.CaptchaSendReqDTO;
import com.lingyi.mall.api.sms.dto.CaptchaVerifyReqDTO;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/7/12 14:22
 * @description
 */
public interface CaptchaService {

    /**
     * 发送验证码
     *
     * @param captchaSendReqDTO 。。
     */

    void send(CaptchaSendReqDTO captchaSendReqDTO);


    /**
     * 校验验证码
     *
     * @param captchaVerifyReqDTO 。。
     * @return 结果
     */
    void verify(CaptchaVerifyReqDTO captchaVerifyReqDTO);

}
