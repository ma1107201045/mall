package com.lingyi.mall.api.sms.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/7/12 14:23
 * @description
 */

@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class CaptchaSendReqDTO extends CaptchaReqDTO {

    /**
     * 验证码
     */
    private String captcha;
    /**
     * 验证码长度
     */
    private Integer length;
    /**
     * 验证码有效期 （分钟）
     */
    private Integer expiryDate;
    /**
     * 验证码发送间隔时间（分钟）
     */
    private Integer intervalDate;
    /**
     * 验证码每天上限
     */
    private Integer upperLimit;
    /**
     * 备注
     */
    private String remark;
}
