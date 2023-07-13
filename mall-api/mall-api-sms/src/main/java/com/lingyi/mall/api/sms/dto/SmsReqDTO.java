package com.lingyi.mall.api.sms.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/7/12 14:23
 * @description
 */
@Data
public class SmsReqDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 403346381956934054L;

    /**
     * 服务
     */
    private String serviceType;

    /**
     * 业务
     */
    private Integer businessType;

    /**
     * 手机号
     */
    private String phoneNumber;

    /**
     * 验证码长度
     */
    private Integer captchaLength;

    /**
     * 备注
     */
    private String remark;
}
