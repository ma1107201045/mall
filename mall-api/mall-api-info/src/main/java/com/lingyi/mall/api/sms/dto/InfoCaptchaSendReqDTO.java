package com.lingyi.mall.api.sms.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * @Author: maweiyan
 * @Email 1107201045@qq.com
 * @DateTime: 2023/10/15 15:26
 * @Description:
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class InfoCaptchaSendReqDTO extends InfoReqDTO {
    /**
     * 验证码
     */
    private String captcha;

    /**
     * 验证码长度
     */
    private Integer captchaLength;
    /**
     * 验证码有效期 （分钟）
     */
    private Integer captchaExpiryDate;
}
