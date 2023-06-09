package com.lingyi.mall.biz.system.entity;

import com.lingyi.mall.common.base.entity.BaseIsDeleteDO;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/4/30 22:43
 * @description 系统管理-菜单表
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Entity
@Table(name = "ms_menu")
public class MenuDO extends BaseIsDeleteDO implements Serializable {

    @Serial
    private static final long serialVersionUID = -6881064204751732279L;

    @Column(name = "name", columnDefinition = "VARCHAR(20) NOT NULL COMMENT '菜单名称'")
    private String name;

    @Column(name = "type", columnDefinition = "TINYINT(4) UNSIGNED NOT NULL COMMENT '菜单类型'")
    private Integer type;

    @Column(name = "parent_id", columnDefinition = "BIGINT(20) UNSIGNED NOT NULL COMMENT '父级菜单id'")
    private Long parentId;

    @Column(name = "icon", columnDefinition = "VARCHAR(50) DEFAULT '' COMMENT '菜单图标'")
    private String icon;

    @Column(name = "sort", columnDefinition = "INT(11) UNSIGNED DEFAULT NULL COMMENT '菜单顺序'")
    private Integer sort;

    @Column(name = "is_enable", columnDefinition = "TINYINT(4) UNSIGNED NOT NULL COMMENT '是否启用 1 是 0 否'")
    private Integer isEnable;

    @Column(name = "path", columnDefinition = "VARCHAR(100) DEFAULT '' COMMENT '路由地址'")
    private String path;

    @Column(name = "component_path", columnDefinition = "VARCHAR(100) DEFAULT '' COMMENT '组件路径'")
    private String componentPath;

    @Column(name = "component_name", columnDefinition = "VARCHAR(20) DEFAULT '' COMMENT '组件路径'")
    private String componentName;

    @Column(name = "permission", columnDefinition = "VARCHAR(100) DEFAULT '' COMMENT '按钮权限标识'")
    private String permission;

    @Column(name = "remark", columnDefinition = "VARCHAR(200) DEFAULT '' COMMENT '备注'")
    private String remark;
    /**
     * 角色集
     */
    @ToString.Exclude
    @ManyToMany
    @JoinTable(name = "ms_role_menu",
            joinColumns = @JoinColumn(name = "menu_id"), inverseJoinColumns = @JoinColumn(name = "role_id"),
            foreignKey = @ForeignKey(name = "fk_menu_id"), inverseForeignKey = @ForeignKey(name = "fk_role_id2"),
            uniqueConstraints = {@UniqueConstraint(name = "fk_menu_id", columnNames = "menu_id"), @UniqueConstraint(name = "fk_role_id2", columnNames = "role_id")})
    private List<RoleDO> roles;
}