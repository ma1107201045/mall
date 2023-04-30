package com.lingyi.mall.biz.system.entity;

import com.lingyi.mall.common.bean.entity.BaseIsDeleteEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serial;
import java.util.List;
import java.util.Objects;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/4/30 22:43
 * @description
 */
@Getter
@Setter
@ToString(callSuper = true)
@Entity
@Table(name = "mbs_role")
public class MbsRole extends BaseIsDeleteEntity {

    @Serial
    private static final long serialVersionUID = 1102684027983288780L;
    /**
     * 角色名称
     */
    @Column(name = "name", length = 20)
    private String name;

    /**
     * 是否启用 1 是 0 否
     */
    @Column(name = "is_enable", columnDefinition = "TINYINT UNSIGNED not null")
    private Integer isEnable;

    /**
     * 顺序
     */
    @Column(name = "sort", columnDefinition = "INT UNSIGNED not null")
    private Integer sort;

    /**
     * 备注
     */
    @Column(name = "remark")
    private String remark;

    /**
     * 菜单集
     */
    @OneToMany(fetch = FetchType.LAZY)
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