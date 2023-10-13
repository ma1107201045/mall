package com.lingyi.mall.biz.system.model.dto;

import com.lingyi.mall.common.core.dto.BaseIdDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serial;
import java.util.List;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/5/15 14:17
 * @description
 */

@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Schema(description = "角色")
public class RoleDTO extends BaseIdDTO<Long> {

    @Serial
    private static final long serialVersionUID = -1734876026099102192L;

    @Schema(description = "角色名称")
    @NotBlank(message = "角色名称不能为空")
    @Size(min = 1, max = 20, message = "角色名称长度只能1-20之间")
    private String name;

    @Schema(description = "是否启用 1 是 0 否")
    @NotNull(message = "是否启用不能为空")
    private Integer isEnable;

    @Schema(description = "角色顺序")
    @NotNull(message = "角色顺序不能为空")
    private Integer sort;

    @Schema(description = "备注")
    private String remark;

    @Schema(description = "菜单id集")
    @NotNull(message = "菜单id集不能为空")
    @Size(min = 1, message = "菜单id集不能为空")
    private List<Long> menuIds;
}
