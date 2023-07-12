package com.lingyi.mall.biz.sms.dto;

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
@Schema(description = "用户")
@Data
public class SmsDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 403346381956934054L;

    @Schema(description = "服务名")
    private String serviceName;

    @Schema(description = "业务名")
    private String businessName;

    @Schema(description = "手机号")
    private String phoneNumber;

    @Schema(description = "验证码长度")
    private Integer captchaLength;

    @Schema(description = "备注")
    private String remark;
}
