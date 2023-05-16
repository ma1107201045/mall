package com.lingyi.mall.api.system.b.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/5/16 15:41
 * @description
 */
@Schema(description = "菜单")
@Data
public class MenuDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = -8275831585548688615L;

    @Schema(description = "菜单id")
    private Long id;

    @Schema(description = "菜单名称", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotBlank(message = "菜单名称不能为空")
    @Size(min = 1, max = 20, message = "菜单名称长度只能1-20之间")
    private String name;

    @Schema(description = "菜单类型 1目录 2 菜单 3 按钮", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "菜单类型不能为空")
    private Integer type;

    @Schema(description = "父级菜单id", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "父级菜单id不能为空")
    private Long parentId;

    @Schema(description = "菜单图标")
    private String icon;

    @Schema(description = "菜单顺序", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "菜单顺序不能为空")
    private Integer sort;

    @Schema(description = "备注")
    private String remark;

    @Schema(description = "是否启用 1 是 0 否", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "是否启用不能为空")
    private Integer isEnable;

    @Schema(description = " 路由地址")
    private String path;

    @Schema(description = " 组件路径")
    private String componentPath;

    @Schema(description = " 组件名称")
    private String componentName;

    @Schema(description = " 按钮权限标识")
    private String permission;
}
