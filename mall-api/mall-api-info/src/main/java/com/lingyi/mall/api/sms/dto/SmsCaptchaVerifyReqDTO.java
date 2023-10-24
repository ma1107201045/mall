package com.lingyi.mall.api.sms.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * @Author: maweiyan
 * @Email 1107201045@qq.com
 * @DateTime: 2023/10/15 15:34
 * @Description:
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class SmsCaptchaVerifyReqDTO extends AbstractSmsReqDTO {
    /**
     * 验证码
     */
    private String captcha;

}
