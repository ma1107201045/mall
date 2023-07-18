package com.lingyi.mall.api.sms.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serial;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/7/13 16:43
 * @description
 */

@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class CaptchaVerifyReqDTO extends CaptchaReqDTO {
    @Serial
    private static final long serialVersionUID = 7129657135976760489L;

    /**
     * 验证码
     */
    private String captcha;



}
