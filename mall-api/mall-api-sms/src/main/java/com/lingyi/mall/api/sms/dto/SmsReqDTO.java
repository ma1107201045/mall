package com.lingyi.mall.api.sms.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/7/13 16:46
 * @description
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class SmsReqDTO extends SmsAbstractReqDTO {

    /**
     * 短信类型 1.验证码
     */
    private Integer type;

    /**
     * 每天发送上限
     */
    private Integer upperLimit;

    /**
     * 发送间隔
     */
    private Integer interval;


    /**
     * 验证码长度
     */
    private Integer captchaLength;
    /**
     * 验证码有效期 （分钟）
     */
    private Integer captchaExpiryDate;

    /**
     * 备注
     */
    private String remark;

}
