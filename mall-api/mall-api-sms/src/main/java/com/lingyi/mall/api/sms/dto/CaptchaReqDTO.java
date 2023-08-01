package com.lingyi.mall.api.sms.dto;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/7/13 16:46
 * @description
 */
@Data
public class CaptchaReqDTO {


    /**
     * 服务类型
     */
    private Integer serviceType;

    /**
     * 业务类型
     */
    private Integer businessType;

    /**
     * 手机号
     */
    private String phoneNumber;
}
