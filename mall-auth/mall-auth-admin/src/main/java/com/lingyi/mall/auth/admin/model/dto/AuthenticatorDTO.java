package com.lingyi.mall.auth.admin.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

/**
 * @Author: maweiyan
 * @Email 1107201045@qq.com
 * @DateTime: 2024/1/8 20:46
 * @Description:
 */
@Data
@Schema(description = "认证信息")
public class AuthenticatorDTO {

    @Schema(description = "用户名")
    @NotBlank(message = "用户名不能为空")
    private String userName;

    @Schema(description = "密码")
    @NotBlank(message = "密码不能为空")
    private String password;

    @Schema(description = "是否记住我 1 是 0 否")
    @NotBlank(message = "是否记住我不能为空")
    private Integer isRememberMe;

    @Schema(description = "图像验证码")
    @NotBlank(message = "图像验证码不能为空")
    private String imageCaptcha;


}
