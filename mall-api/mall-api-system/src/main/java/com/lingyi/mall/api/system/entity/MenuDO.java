package com.lingyi.mall.api.system.entity;

import com.lingyi.mall.common.base.entity.BaseIsDeleteDO;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/4/30 22:43
 * @description 系统管理-菜单表
 */
@Getter
@Setter
@ToString(callSuper = true)
@DynamicInsert
@DynamicUpdate
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
    @ManyToMany
    @JoinTable(name = "ms_role_menu",
            joinColumns = @JoinColumn(name = "menu_id"), inverseJoinColumns = @JoinColumn(name = "role_id"),
            foreignKey = @ForeignKey(name = "fk_menu_id"), inverseForeignKey = @ForeignKey(name = "fk_role_id2"),
            uniqueConstraints = {@UniqueConstraint(name = "fk_menu_id", columnNames = "menu_id"), @UniqueConstraint(name = "fk_role_id2", columnNames = "role_id")})
    @ToString.Exclude
    private List<RoleDO> roleDOS;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        MenuDO mbsMenuDO = (MenuDO) o;
        if (!Objects.equals(name, mbsMenuDO.name)) {
            return false;
        }
        if (!Objects.equals(type, mbsMenuDO.type)) {
            return false;
        }
        if (!Objects.equals(parentId, mbsMenuDO.parentId)) {
            return false;
        }
        if (!Objects.equals(icon, mbsMenuDO.icon)) {
            return false;
        }
        if (!Objects.equals(sort, mbsMenuDO.sort)) {
            return false;
        }
        if (!Objects.equals(remark, mbsMenuDO.remark)) {
            return false;
        }
        if (!Objects.equals(isEnable, mbsMenuDO.isEnable)) {
            return false;
        }
        if (!Objects.equals(path, mbsMenuDO.path)) {
            return false;
        }
        if (!Objects.equals(componentPath, mbsMenuDO.componentPath)) {
            return false;
        }
        if (!Objects.equals(componentName, mbsMenuDO.componentName)) {
            return false;
        }
        if (!Objects.equals(permission, mbsMenuDO.permission)) {
            return false;
        }
        return Objects.equals(roleDOS, mbsMenuDO.roleDOS);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (parentId != null ? parentId.hashCode() : 0);
        result = 31 * result + (icon != null ? icon.hashCode() : 0);
        result = 31 * result + (sort != null ? sort.hashCode() : 0);
        result = 31 * result + (remark != null ? remark.hashCode() : 0);
        result = 31 * result + (isEnable != null ? isEnable.hashCode() : 0);
        result = 31 * result + (path != null ? path.hashCode() : 0);
        result = 31 * result + (componentPath != null ? componentPath.hashCode() : 0);
        result = 31 * result + (componentName != null ? componentName.hashCode() : 0);
        result = 31 * result + (permission != null ? permission.hashCode() : 0);
        result = 31 * result + (roleDOS != null ? roleDOS.hashCode() : 0);
        return result;
    }
}