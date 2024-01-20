package com.lingyi.mall.auth.admin.model.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @Author: maweiyan
 * @Email: 1107201045@qq.com
 * @DateTime: 2024/1/20 9:30
 * @Description:
 */
@Data
@Schema(description = "认证完整信息")
public class AuthenticatorVO {

    @Schema(description = "用户id")
    private Long userId;
}
