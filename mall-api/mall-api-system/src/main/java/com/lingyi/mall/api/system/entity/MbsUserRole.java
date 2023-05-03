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
 * @description 系统管理-用户角色中间表
 */
@Getter
@Setter
@ToString(callSuper = true)
@NoArgsConstructor
@SuperBuilder
@Entity
@Table(name = "mbs_user_role")
public class MbsUserRole extends BaseCommonEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 506747689975729762L;

    /**
     * 用户id
     */
    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REMOVE}, fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    @ToString.Exclude
    private MbsUser mbsUser;
    /**
     * 角色id
     */
    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REMOVE}, fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "role_id", nullable = false)
    @ToString.Exclude
    private MbsRole mbsRole;

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
        if (!Objects.equals(mbsUser, that.mbsUser)) {
            return false;
        }
        return Objects.equals(mbsRole, that.mbsRole);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (mbsUser != null ? mbsUser.hashCode() : 0);
        result = 31 * result + (mbsRole != null ? mbsRole.hashCode() : 0);
        return result;
    }
}