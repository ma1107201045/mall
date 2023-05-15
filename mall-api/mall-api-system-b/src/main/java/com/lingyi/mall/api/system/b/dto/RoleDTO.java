package com.lingyi.mall.api.system.b.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/5/15 14:17
 * @description
 */
@Schema(description = "角色")
@Data
public class RoleDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = -7189349120052738779L;

    @Schema(description = "角色名称")
    private String name;

    @Schema(description = " 是否启用 1 是 0 否")
    private Integer isEnable;

    @Schema(description = "顺序")
    private Integer sort;

    @Schema(description = "备注")
    private String remark;

    @Schema(description = "菜单id集")
    private List<Long> menus;
}
