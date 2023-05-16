package com.lingyi.mall.api.system.b.entity;

import com.lingyi.mall.common.bean.entity.BaseCommonEntity;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/4/30 22:43
 * @description 系统管理-角色按钮中间表
 */
@Getter
@Setter
@ToString(callSuper = true)
@DynamicInsert
@DynamicUpdate
@Entity
@Table(name = "mbs_role_menu")
public class RoleMenu extends BaseCommonEntity implements Serializable {


    @Serial
    private static final long serialVersionUID = -1115350215761364818L;
    /**
     * 角色id
     */
    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REMOVE}, fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "role_id", nullable = false)
    @ToString.Exclude
    private Role role;
    /**
     * 菜单id
     */
    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REMOVE}, fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "menu_id", nullable = false)
    @ToString.Exclude
    private Menu menu;

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
        RoleMenu that = (RoleMenu) o;
        if (!Objects.equals(role, that.role)) {
            return false;
        }
        return Objects.equals(menu, that.menu);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (role != null ? role.hashCode() : 0);
        result = 31 * result + (menu != null ? menu.hashCode() : 0);
        return result;
    }

    public static RoleMenu of(Long roleId, Long menuId) {
        Role newRole = new Role();
        newRole.setId(roleId);
        Menu newMenu = new Menu();
        newMenu.setId(menuId);
        RoleMenu roleMenu = new RoleMenu();
        roleMenu.setRole(newRole);
        roleMenu.setMenu(newMenu);
        return roleMenu;
    }
}