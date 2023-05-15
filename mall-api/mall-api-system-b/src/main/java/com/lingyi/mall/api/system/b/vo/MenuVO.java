package com.lingyi.mall.api.system.b.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/5/5 16:25
 * @description
 */
@Schema(description = "菜单")
@Data
public class MenuVO implements Serializable {
    @Serial
    private static final long serialVersionUID = -7753690884211490825L;

    @Schema(description = "菜单id")
    private Long menuId;

    @Schema(description = "菜单名称")
    private Long name;

    @Schema(description = "菜单图标")
    private Long icon;

    @Schema(description = "路由地址")
    private Long path;

    @Schema(description = "菜单子级")
    private List<MenuVO> menus;
}
