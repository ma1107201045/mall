package com.lingyi.mall.api.sms.dto;

import lombok.Data;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/7/13 16:46
 * @description
 */
@Data
public class SmsReqDTO {


    /**
     * 服务类型
     */
    private Integer serviceType;

    /**
     * 业务类型
     */
    private Integer businessType;

    /**
     * 短信类型 1.验证密码
     */
    private Integer type;

    /**
     * 手机号
     */
    private String phoneNumber;
}
