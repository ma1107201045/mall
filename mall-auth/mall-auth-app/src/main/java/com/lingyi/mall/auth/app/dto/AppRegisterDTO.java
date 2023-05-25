package com.lingyi.mall.auth.app.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/5/25 15:52
 * @description
 */
@Schema(description = "注册")
@Data
public class AppRegisterDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = 4864556230518330116L;

    @Schema(description = "手机号")
    @NotBlank(message = "手机号不能为空")
    private String phoneNumber;

    @Schema(description = "用户名称")
    @NotBlank(message = "用户名称不能为空")
    private String userName;

    @Schema(description = "密码")
    @NotBlank(message = "密码不能为空")
    private String password;
}
