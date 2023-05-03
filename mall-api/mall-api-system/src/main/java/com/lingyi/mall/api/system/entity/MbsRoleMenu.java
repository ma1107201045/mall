package com.lingyi.mall.api.system.entity;

import com.lingyi.mall.common.bean.entity.BaseCommonEntity;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

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
@NoArgsConstructor
@SuperBuilder
@Entity
@Table(name = "mbs_role_menu")
public class MbsRoleMenu extends BaseCommonEntity implements Serializable {


    @Serial
    private static final long serialVersionUID = -1115350215761364818L;
    /**
     * 角色id
     */
    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REMOVE}, fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "role_id", nullable = false)
    @ToString.Exclude
    private MbsRole mbsRole;
    /**
     * 菜单id
     */
    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REMOVE}, fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "menu_id", nullable = false)
    @ToString.Exclude
    private MbsMenu mbsMenu;

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
        MbsRoleMenu that = (MbsRoleMenu) o;
        if (!Objects.equals(mbsRole, that.mbsRole)) {
            return false;
        }
        return Objects.equals(mbsMenu, that.mbsMenu);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (mbsRole != null ? mbsRole.hashCode() : 0);
        result = 31 * result + (mbsMenu != null ? mbsMenu.hashCode() : 0);
        return result;
    }
}