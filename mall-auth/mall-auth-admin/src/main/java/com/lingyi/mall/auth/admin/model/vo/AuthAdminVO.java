package com.lingyi.mall.auth.admin.model.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @Author: maweiyan
 * @Email 1107201045@qq.com
 * @DateTime: 2024/1/8 20:49
 * @Description:
 */
@Data
public class AuthAdminVO {

    @Schema(description = "用户id")
    private Long userId;
}
