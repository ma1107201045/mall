package com.lingyi.mall.api.sms.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serial;
import java.io.Serializable;

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

    @Serial
    private static final long serialVersionUID = 403346381956934054L;


    /**
     * 验证码长度
     */
    private Integer length;

    /**
     * 验证码有效期 （分钟）
     */
    private Integer expiryDate;

    /**
     * 备注
     */
    private String remark;
}
