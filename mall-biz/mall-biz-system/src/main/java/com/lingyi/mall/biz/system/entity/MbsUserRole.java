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
@Table(name = "mbs_user_role")
public class MbsUserRole extends BaseCommonEntity {


    @Serial
    private static final long serialVersionUID = 8014384457001360009L;
    /**
     * 用户id
     */
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private MbsUser user;
    /**
     * 角色id
     */
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "role_id", nullable = false)
    private MbsRole role;

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
        MbsUserRole that = (MbsUserRole) o;
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