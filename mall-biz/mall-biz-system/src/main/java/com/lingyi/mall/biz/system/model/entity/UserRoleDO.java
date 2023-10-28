package com.lingyi.mall.biz.system.model.entity;

import com.lingyi.mall.common.orm.entity.BaseCommonDO;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.io.Serial;
import java.io.Serializable;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/4/30 22:43
 * @description 系统管理-用户角色中间表
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Entity
@Table(name = "ms_user_role")
@DynamicInsert
public class UserRoleDO extends BaseCommonDO implements Serializable {

    @Serial
    private static final long serialVersionUID = 506747689975729762L;

    @ManyToOne(cascade = {CascadeType.REMOVE}, optional = false)
    @JoinColumn(name = "user_id", columnDefinition = "BIGINT(20) UNSIGNED NOT NULL COMMENT '用户id'")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private UserDO userDO;
    /**
     * 角色id
     */
    @ManyToOne(cascade = {CascadeType.REMOVE}, fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "role_id", columnDefinition = "BIGINT(20) UNSIGNED NOT NULL COMMENT '角色id'")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private RoleDO roleDO;

}