package com.lingyi.mall.api.system.entity;

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
 * @description 系统管理-用户角色中间表
 */
@Getter
@Setter
@ToString(callSuper = true)
@DynamicInsert
@DynamicUpdate
@Entity
@Table(name = "mbs_user_role")
public class UserRole extends BaseCommonEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 506747689975729762L;

    /**
     * 用户id
     */
    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REMOVE}, fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    @ToString.Exclude
    private User user;
    /**
     * 角色id
     */
    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REMOVE}, fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "role_id", nullable = false)
    @ToString.Exclude
    private Role role;

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
        UserRole that = (UserRole) o;
        if (!Objects.equals(user, that.user)) {
            return false;
        }
        return Objects.equals(role, that.role);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (user != null ? user.hashCode() : 0);
        result = 31 * result + (role != null ? role.hashCode() : 0);
        return result;
    }
}