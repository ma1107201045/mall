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
