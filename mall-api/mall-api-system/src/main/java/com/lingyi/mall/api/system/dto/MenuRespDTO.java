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
 * @description 菜单
 */
@Data
@Schema(description = "按钮")
public class MenuRespDTO implements Serializable {


    @Serial
    private static final long serialVersionUID = -6547543624077153061L;

    @Schema(description = "菜单id")
    private Long id;
    /**
     * 父级菜单id
     */
    private Long parentId;
    /**
     * 菜单名称
     */
    private String name;

    /**
     * 菜单类型 1目录 2 菜单 3 按钮
     */
    private Integer type;

    /**
     * 菜单图标
     */
    private String icon;

    /**
     * 菜单顺序
     */
    private Integer sort;

    /**
     * 是否启用 1 是 0 否
     */
    private Integer isEnable;

    /**
     * 路由名称
     */
    private String routeName;

    /**
     * 路由地址
     */
    private String routePath;

    /**
     * 组件名称
     */
    private String componentName;
    /**
     * 按钮权限标识
     */
    private String permission;
    /**
     * 备注
     */
    private String remark;
    /**
     * 创建人
     */
    private String createBy;
    /**
     * 创建人
     */
    private LocalDateTime createDateTime;
    /**
     * 最后一次更新人
     */
    private String lastModifyBy;
    /**
     * 最后一次更新时间
     */
    private LocalDateTime lastModifyDateTime;
    /**
     * 菜单子级
     */
    private List<MenuRespDTO> children;
}
