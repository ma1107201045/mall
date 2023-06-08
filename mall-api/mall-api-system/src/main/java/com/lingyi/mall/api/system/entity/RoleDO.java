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
 * @description 系统管理-角色表
 */
@Getter
@Setter
@ToString(callSuper = true)
@DynamicInsert
@DynamicUpdate
@Entity
@Table(name = "ms_role")
public class RoleDO extends BaseIsDeleteDO implements Serializable {

    @Serial
    private static final long serialVersionUID = -5280755884593902334L;

    @Column(name = "name", columnDefinition = "VARCHAR(20) NOT NULL COMMENT '角色名称'")
    private String name;

    @Column(name = "sort", columnDefinition = "INT(11) UNSIGNED DEFAULT NULL COMMENT '角色顺序'")
    private Integer sort;

    @Column(name = "is_enable", columnDefinition = "TINYINT(4) NOT NULL COMMENT '是否启用 1 是 0 否'")
    private Integer isEnable;

    @Column(name = "remark", columnDefinition = "VARCHAR(200) DEFAULT '' COMMENT '备注'")
    private String remark;

    /**
     * 用户集
     */
    @ManyToMany
    @JoinTable(name = "ms_user_role",
            joinColumns = @JoinColumn(name = "role_id"), inverseJoinColumns = @JoinColumn(name = "user_id"),
            foreignKey = @ForeignKey(name = "fk_role_id"), inverseForeignKey = @ForeignKey(name = "fk_user_id"),
            indexes = {@Index(name = "fk_role_id", columnList = "role_id"), @Index(name = "fk_user_id", columnList = "user_id")})
    private List<UserDO> users;

    /**
     * 菜单集
     */
    @ManyToMany(mappedBy = "roles")
    @ToString.Exclude
    private List<MenuDO> menus;

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

        RoleDO roleDO = (RoleDO) o;

        if (!Objects.equals(name, roleDO.name)) {
            return false;
        }
        if (!Objects.equals(isEnable, roleDO.isEnable)) {
            return false;
        }
        if (!Objects.equals(sort, roleDO.sort)) {
            return false;
        }
        if (!Objects.equals(remark, roleDO.remark)) {
            return false;
        }
        if (!Objects.equals(users, roleDO.users)) {
            return false;
        }
        return Objects.equals(menus, roleDO.menus);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (isEnable != null ? isEnable.hashCode() : 0);
        result = 31 * result + (sort != null ? sort.hashCode() : 0);
        result = 31 * result + (remark != null ? remark.hashCode() : 0);
        result = 31 * result + (users != null ? users.hashCode() : 0);
        result = 31 * result + (menus != null ? menus.hashCode() : 0);
        return result;
    }
}