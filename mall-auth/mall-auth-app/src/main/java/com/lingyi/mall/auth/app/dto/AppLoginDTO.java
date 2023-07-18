package com.lingyi.mall.auth.app.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/5/25 16:03
 * @description
 */
@Schema(description = "登录")
@Data
public class AppLoginDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = -8668458806898128715L;

    @Schema(description = "手机号")
    @NotBlank(message = "手机号不能为空")
    private String phoneNumber;

    @Schema(description = "短信验证码")
    @NotBlank(message = "短信验证码不能为空")
    private String smsCaptcha;
}
