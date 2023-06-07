package com.lingyi.mall.api.system.entity;

import com.lingyi.mall.common.base.entity.BaseCommonDO;
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
@Table(name = "ms_role_menu")
public class RoleMenuDO extends BaseCommonDO implements Serializable {


    @Serial
    private static final long serialVersionUID = -1115350215761364818L;
    /**
     * 角色id
     */
    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REMOVE}, fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "role_id", columnDefinition = "BIGINT(20) UNSIGNED NOT NULL COMMENT '角色id'")
    @ToString.Exclude
    private RoleDO roleDO;
    /**
     * 菜单id
     */
    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REMOVE}, fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "menu_id", columnDefinition = "BIGINT(20) UNSIGNED NOT NULL COMMENT '菜单id'")
    @ToString.Exclude
    private MenuDO menuDO;

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
        RoleMenuDO that = (RoleMenuDO) o;
        if (!Objects.equals(roleDO, that.roleDO)) {
            return false;
        }
        return Objects.equals(menuDO, that.menuDO);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (roleDO != null ? roleDO.hashCode() : 0);
        result = 31 * result + (menuDO != null ? menuDO.hashCode() : 0);
        return result;
    }

    public static RoleMenuDO of(Long roleId, Long menuId) {
        RoleDO newRoleDO = new RoleDO();
        newRoleDO.setId(roleId);
        MenuDO newMenuDO = new MenuDO();
        newMenuDO.setId(menuId);
        RoleMenuDO roleMenuDO = new RoleMenuDO();
        roleMenuDO.setRoleDO(newRoleDO);
        roleMenuDO.setMenuDO(newMenuDO);
        return roleMenuDO;
    }
}