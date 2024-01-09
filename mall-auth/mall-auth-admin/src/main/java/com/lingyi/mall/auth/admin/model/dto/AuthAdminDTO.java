package com.lingyi.mall.auth.admin.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @Author: maweiyan
 * @Email 1107201045@qq.com
 * @DateTime: 2024/1/8 20:46
 * @Description:
 */
@Data
@Schema(description = "认证信息")
public class AuthAdminDTO {

    @Schema(description = "用户名")
    private String userName;

    @Schema(description = "密码")
    private String password;


}
