package com.lingyi.mall.api.system.entity;

import com.lingyi.mall.common.base.entity.BaseIsDeleteEntity;
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
@Table(name = "mbs_menu")
public class Menu extends BaseIsDeleteEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = -6881064204751732279L;

    /**
     * 菜单名称
     */
    @Column(name = "name", nullable = false, length = 20)
    private String name;

    /**
     * 菜单类型 1目录 2 菜单 3 按钮
     */
    @Column(name = "type", nullable = false)
    private Integer type;

    /**
     * 父级菜单id
     */
    @Column(name = "parent_id", nullable = false)
    private Long parentId;

    /**
     * 菜单图标
     */
    @Column(name = "icon", length = 50)
    private String icon;

    /**
     * 菜单顺序
     */
    @Column(name = "sort")
    private Integer sort;


    /**
     * 是否启用 1 是 0 否
     */
    @Column(name = "is_enable")
    private Integer isEnable;

    /**
     * 路由地址
     */
    @Column(name = "path", length = 100)
    private String path;

    /**
     * 组件路径
     */
    @Column(name = "component_path", length = 100)
    private String componentPath;

    /**
     * 组件名称
     */
    @Column(name = "component_name", length = 20)
    private String componentName;

    /**
     * 按钮权限标识
     */
    @Column(name = "permission", length = 100)
    private String permission;

    /**
     * 备注
     */
    @Column(name = "remark")
    private String remark;
    /**
     * 角色集
     */
    @ManyToMany
    @JoinTable(name = "mbs_role_menu", joinColumns = @JoinColumn(name = "menu_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    @ToString.Exclude
    private List<Role> roles;

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
        Menu mbsMenu = (Menu) o;
        if (!Objects.equals(name, mbsMenu.name)) {
            return false;
        }
        if (!Objects.equals(type, mbsMenu.type)) {
            return false;
        }
        if (!Objects.equals(parentId, mbsMenu.parentId)) {
            return false;
        }
        if (!Objects.equals(icon, mbsMenu.icon)) {
            return false;
        }
        if (!Objects.equals(sort, mbsMenu.sort)) {
            return false;
        }
        if (!Objects.equals(remark, mbsMenu.remark)) {
            return false;
        }
        if (!Objects.equals(isEnable, mbsMenu.isEnable)) {
            return false;
        }
        if (!Objects.equals(path, mbsMenu.path)) {
            return false;
        }
        if (!Objects.equals(componentPath, mbsMenu.componentPath)) {
            return false;
        }
        if (!Objects.equals(componentName, mbsMenu.componentName)) {
            return false;
        }
        if (!Objects.equals(permission, mbsMenu.permission)) {
            return false;
        }
        return Objects.equals(roles, mbsMenu.roles);
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
        result = 31 * result + (roles != null ? roles.hashCode() : 0);
        return result;
    }
}