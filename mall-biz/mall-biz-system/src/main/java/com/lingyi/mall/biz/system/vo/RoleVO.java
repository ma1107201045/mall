package com.lingyi.mall.biz.system.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/5/15 14:20
 * @description
 */
@Schema(description = "角色")
@Data
public class RoleVO implements Serializable {

    @Serial
    private static final long serialVersionUID = -8232018926303483971L;

    @Schema(description = "角色id")
    private Long id;

    @Schema(description = "角色名称")
    private String name;

    @Schema(description = " 是否启用 1 是 0 否")
    private Integer isEnable;

    @Schema(description = "顺序")
    private Integer sort;

    @Schema(description = "备注")
    private String remark;

    @Schema(description = "创建人")
    private String createBy;

    @Schema(description = "创建时间")
    private LocalDateTime createDateTime;

    @Schema(description = "最后一次更新人")
    private String lastModifyBy;

    @Schema(description = "最后一次更新时间")
    private LocalDateTime lastModifyDateTime;

    @Schema(description = "菜单id集")
    private List<Long> menuIds;
}
