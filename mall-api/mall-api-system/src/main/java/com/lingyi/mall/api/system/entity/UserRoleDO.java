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
 * @description 系统管理-用户角色中间表
 */
@Getter
@Setter
@ToString(callSuper = true)
@DynamicInsert
@DynamicUpdate
@Entity
@Table(name = "ms_user_role")
public class UserRoleDO extends BaseCommonDO implements Serializable {

    @Serial
    private static final long serialVersionUID = 506747689975729762L;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REMOVE}, fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", columnDefinition = "BIGINT(20) UNSIGNED NOT NULL COMMENT '用户id'")
    private UserDO userDO;
    /**
     * 角色id
     */
    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REMOVE}, fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "role_id", columnDefinition = "BIGINT(20) UNSIGNED NOT NULL COMMENT '角色id'")
    private RoleDO roleDO;

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
        UserRoleDO that = (UserRoleDO) o;
        if (!Objects.equals(userDO, that.userDO)) {
            return false;
        }
        return Objects.equals(roleDO, that.roleDO);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (userDO != null ? userDO.hashCode() : 0);
        result = 31 * result + (roleDO != null ? roleDO.hashCode() : 0);
        return result;
    }

    public static UserRoleDO of(Long userId, Long roleId) {
        UserDO newUserDO = new UserDO();
        newUserDO.setId(userId);
        RoleDO newRoleDO = new RoleDO();
        newRoleDO.setId(roleId);
        UserRoleDO userRoleDO = new UserRoleDO();
        userRoleDO.setUserDO(newUserDO);
        userRoleDO.setRoleDO(newRoleDO);
        return userRoleDO;
    }
}