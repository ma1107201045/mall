package com.lingyi.mall.api.member.entity;

import com.lingyi.mall.common.base.entity.BaseIdEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.io.Serial;
import java.io.Serializable;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/5/24 14:53
 * @description
 */
@Getter
@Setter
@ToString(callSuper = true)
@DynamicInsert
@DynamicUpdate
@Entity
@Table(name = "mm_member_level")
public class MemberLevel extends BaseIdEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 1698976479509049883L;

    /**
     * 等级名称
     */
    @Column(name = "name", nullable = false, length = 20)
    private String name;

    /**
     * 增长点
     */
    @Column(name = "growth_point", nullable = false)
    private Integer growthPoint;

    /**
     * 每次评价获取的成长值
     */
    @Column(name = "comment_growth_point", nullable = false)
    private Integer commentGrowthPoint;

    /**
     * 是否为默认等级：0->不是；1->是
     */
    @Column(name = "is_default_level", nullable = false)
    private Integer isDefaultLevel;

    /**
     * 备注
     */
    @Column(name = "remark")
    private String remark;
}
