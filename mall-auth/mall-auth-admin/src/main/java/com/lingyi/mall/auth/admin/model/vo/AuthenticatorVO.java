package com.lingyi.mall.auth.admin.model.vo;

import com.lingyi.mall.security.core.util.Authenticator;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serial;

/**
 * @Author: maweiyan
 * @Email 1107201045@qq.com
 * @DateTime: 2024/1/8 20:49
 * @Description:
 */

@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class AuthenticatorVO extends Authenticator {

    @Serial
    private static final long serialVersionUID = 4577982567531916924L;

    @Schema(description = "用户id")
    private Long userId;
}
