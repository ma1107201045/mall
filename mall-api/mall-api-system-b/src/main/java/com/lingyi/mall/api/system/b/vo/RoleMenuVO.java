package com.lingyi.mall.api.system.b.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/5/15 14:34
 * @description
 */
@Schema(description = "角色菜单")
@Data
public class RoleMenuVO implements Serializable {
    @Serial
    private static final long serialVersionUID = 9055827785236118241L;

    @Schema(description = "用户角色id")
    private Long roleMenuId;

    @Schema(description = "角色id")
    private Long roleId;

    @Schema(description = "菜单id")
    private Long menuId;

    @Schema(description = "创建人")
    private String createBy;

    @Schema(description = "创建时间")
    private LocalDateTime createDateTime;

    @Schema(description = "最后一次更新人")
    private String lastModifyBy;

    @Schema(description = "最后一次更新时间")
    private LocalDateTime lastModifyDateTime;
}
