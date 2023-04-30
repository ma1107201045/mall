package com.lingyi.mall.biz.system.entity;

import com.lingyi.mall.common.bean.entity.BaseCommonEntity;
import com.lingyi.mall.common.bean.entity.BaseIsDeleteEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.time.Instant;
import java.util.Objects;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/4/30 22:43
 * @description
 */
@Getter
@Setter
@Entity
@Table(name = "mbs_role_menu")
public class MbsRoleMenu extends BaseCommonEntity {


    @Serial
    private static final long serialVersionUID = 5220840951929146643L;
    /**
     * 角色id
     */
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "role_id", nullable = false)
    private MbsRole role;
    /**
     * 菜单id
     */
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "menu_id", nullable = false)
    private MbsMenu menu;

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
}