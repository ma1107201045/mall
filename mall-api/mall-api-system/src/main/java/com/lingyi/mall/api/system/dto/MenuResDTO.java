package com.lingyi.mall.api.system.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/6/9 16:11
 * @description
 */
@Schema(description = "菜单")
@Data
public class MenuResDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = -8081768166478917809L;

    @Schema(description = "菜单id")
    private Long id;

    @Schema(description = "菜单名称")
    private Long name;

    @Schema(description = "菜单类型 1目录 2 菜单 3 按钮")
    private Integer type;

    @Schema(description = "父级菜单id")
    private Long parentId;

    @Schema(description = "菜单图标")
    private Long icon;

    @Schema(description = "菜单顺序")
    private Integer sort;

    @Schema(description = "是否启用 1 是 0 否")
    private Integer isEnable;

    @Schema(description = "路由地址")
    private Long path;

    @Schema(description = "组件路径")
    private String componentPath;

    @Schema(description = "组件名称")
    private String componentName;

    @Schema(description = "按钮权限标识")
    private String permission;

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

    @Schema(description = "是否删除 1是 0否")
    private Integer isDelete;

    @Schema(description = "菜单子级")
    private List<MenuResDTO> menus;
}
