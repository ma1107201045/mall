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
 * @description 系统管理-角色按钮中间表
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Entity
@Table(name = "ms_role_menu")
@DynamicInsert
public class RoleMenuDO extends BaseCommonDO implements Serializable {


    @Serial
    private static final long serialVersionUID = -1115350215761364818L;
    /**
     * 角色id
     */
    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REMOVE}, fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "role_id", columnDefinition = "BIGINT(20) UNSIGNED NOT NULL COMMENT '角色id'")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private RoleDO roleDO;
    /**
     * 菜单id
     */
    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REMOVE}, fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "menu_id", columnDefinition = "BIGINT(20) UNSIGNED NOT NULL COMMENT '菜单id'")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private MenuDO menuDO;

}