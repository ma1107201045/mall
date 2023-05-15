package com.lingyi.mall.api.system.b.param;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/5/15 14:22
 * @description
 */
@Schema(description = "角色")
@Data
public class RoleParam implements Serializable {
    @Serial
    private static final long serialVersionUID = -3790408928903411297L;

    @Schema(description = "角色名称")
    private String name;
}
