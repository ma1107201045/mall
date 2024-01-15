package com.lingyi.mall.auth.admin.model.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

/**
 * @Author: maweiyan
 * @Email 1107201045@qq.com
 * @DateTime: 2024/1/8 20:49
 * @Description:
 */
@Data
public class AuthenticatorVO implements Serializable {

    @Serial
    private static final long serialVersionUID = 4577982567531916924L;

    @Schema(description = "用户id")
    private Long userId;
}
