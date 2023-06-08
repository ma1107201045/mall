package com.lingyi.mall.api.member.entity;

import com.lingyi.mall.common.base.entity.BaseIdDO;
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
public class MemberLevelDO extends BaseIdDO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1698976479509049883L;

    @Column(name = "name", columnDefinition = "VARCHAR(20) NOT NULL COMMENT '等级名称'")
    private String name;

    @Column(name = "growth_point", columnDefinition = "INT(11) UNSIGNED NOT NULL COMMENT '增长点'")
    private Integer growthPoint;

    @Column(name = "comment_growth_point", columnDefinition = "INT(11) UNSIGNED NOT NULL COMMENT '每次评价获取的成长值'")
    private Integer commentGrowthPoint;

    @Column(name = "is_default_level", columnDefinition = "TINYINT(4) UNSIGNED NOT NULL COMMENT '是否为默认等级：1是 0否'")
    private Integer isDefaultLevel;

    @Column(name = "remark", columnDefinition = "VARCHAR(200) DEFAULT '' COMMENT '备注'")
    private String remark;
}
