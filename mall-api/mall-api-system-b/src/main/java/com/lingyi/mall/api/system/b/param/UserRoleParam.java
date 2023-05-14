package com.lingyi.mall.api.system.b.param;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

/**
 * @Author: maweiyan
 * @Email 1107201045@qq.com
 * @DateTime: 2023/5/14 20:04
 * @Description:
 */
@Schema(description = "用户角色")
@Data
public class UserRoleParam implements Serializable {

    @Serial
    private static final long serialVersionUID = -1471571461591345878L;

    @Schema(description = "用户id")
    private Long userId;

    @Schema(description = "角色id")
    private Long roleId;
}
