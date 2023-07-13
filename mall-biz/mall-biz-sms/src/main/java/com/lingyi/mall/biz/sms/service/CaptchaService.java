package com.lingyi.mall.biz.sms.service;

import com.lingyi.mall.api.sms.dto.CaptchaReqDTO;

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
     * @param captchaReqDTO 。。
     */

    void send(CaptchaReqDTO captchaReqDTO);

}
