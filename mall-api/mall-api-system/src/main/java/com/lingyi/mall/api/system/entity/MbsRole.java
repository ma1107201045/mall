package com.lingyi.mall.api.system.entity;

import com.lingyi.mall.common.bean.entity.BaseIsDeleteEntity;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
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
 * @description 系统管理-角色表
 */
@Getter
@Setter
@ToString(callSuper = true)
@DynamicInsert
@DynamicUpdate
@Entity
@Table(name = "mbs_role")
public class MbsRole extends BaseIsDeleteEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = -5280755884593902334L;
    /**
     * 角色名称
     */
    @Column(name = "name", length = 20)
    private String name;

    /**
     * 是否启用 1 是 0 否
     */
    @Column(name = "is_enable", length = 4)
    private Integer isEnable;

    /**
     * 顺序
     */
    @Column(name = "sort", length = 11)
    private Integer sort;

    /**
     * 备注
     */
    @Column(name = "remark")
    private String remark;

    /**
     * 用户集
     */
    @ManyToMany
    @JoinTable(name = "mbs_user_role", joinColumns = @JoinColumn(name = "role_id"), inverseJoinColumns = @JoinColumn(name = "user_id"))
    @ToString.Exclude
    private List<MbsUser> mbsUsers;

    /**
     * 菜单集
     */
    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "mbsRoles")
    @ToString.Exclude
    private List<MbsMenu> mbsMenus;

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

        MbsRole mbsRole = (MbsRole) o;

        if (!Objects.equals(name, mbsRole.name)) {
            return false;
        }
        if (!Objects.equals(isEnable, mbsRole.isEnable)) {
            return false;
        }
        if (!Objects.equals(sort, mbsRole.sort)) {
            return false;
        }
        if (!Objects.equals(remark, mbsRole.remark)) {
            return false;
        }
        return Objects.equals(mbsMenus, mbsRole.mbsMenus);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (isEnable != null ? isEnable.hashCode() : 0);
        result = 31 * result + (sort != null ? sort.hashCode() : 0);
        result = 31 * result + (remark != null ? remark.hashCode() : 0);
        result = 31 * result + (mbsMenus != null ? mbsMenus.hashCode() : 0);
        return result;
    }
}