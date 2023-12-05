package com.lingyi.mall.auth.app.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

/**
 * @Author: maweiyan
 * @Email: 1107201045@qq.com
 * @DateTime: 2023/12/5 14:16
 * @Description:
 */
@Schema(description = "登录")
@Data
public class AuthAppEmailLoginDTO {

    @Schema(description = "邮箱号")
    @NotBlank(message = "邮箱号不能为空")
    private String emailNumber;

    @Schema(description = "短信验证码")
    @NotBlank(message = "短信验证码不能为空")
    private String emailCaptcha;
}
