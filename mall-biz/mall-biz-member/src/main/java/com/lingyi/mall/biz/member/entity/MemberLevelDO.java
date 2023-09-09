package com.lingyi.mall.biz.member.entity;

import com.lingyi.mall.common.orm.entity.BaseIdDO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.hibernate.annotations.DynamicInsert;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/5/24 14:53
 * @description
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Entity
@Table(name = "mm_member_level")
@DynamicInsert
public class MemberLevelDO extends BaseIdDO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1698976479509049883L;

    @Column(name = "name", columnDefinition = "VARCHAR(20) NOT NULL COMMENT '等级名称'")
    private String name;

    @Column(name = "growth_point", columnDefinition = "INT(11) UNSIGNED NOT NULL COMMENT '增长点'")
    private Integer growthPoint;

    @Column(name = "comment_growth_point", columnDefinition = "INT(11) UNSIGNED NOT NULL COMMENT '每次评价获取的成长值'")
    private Integer commentGrowthPoint;

    @Column(name = "is_default_level", columnDefinition = "TINYINT(4) UNSIGNED NOT NULL COMMENT '是否为默认等级：1 是 0 否'")
    private Integer isDefaultLevel;

    @Column(name = "is_priviledge_free_freight", columnDefinition = "TINYINT(4) UNSIGNED NOT NULL COMMENT '是否有免邮特权:1 是 0 否'")
    private Integer isPriviledgeFreeFreight;

    @Column(name = "is_priviledge_sign_in", columnDefinition = "TINYINT(4) UNSIGNED NOT NULL COMMENT '是否有签到特权:1 是 0 否'")
    private Integer isPriviledgeSignIn;

    @Column(name = "is_priviledge_comment", columnDefinition = "TINYINT(4) UNSIGNED NOT NULL COMMENT '是否有评论获奖励特权:1 是 0 否'")
    private Integer isPriviledgeComment;

    @Column(name = "is_priviledge_promotion", columnDefinition = "TINYINT(4) UNSIGNED NOT NULL COMMENT '是否有专享活动特权:1 是 0 否'")
    private Integer isPriviledgePromotion;

    @Column(name = "is_priviledge_member_price", columnDefinition = "TINYINT(4) UNSIGNED NOT NULL COMMENT '是否有会员价格特权:1 是 0 否'")
    private Integer isPriviledgeMemberPrice;

    @Column(name = "is_priviledge_birthday", columnDefinition = "TINYINT(4) UNSIGNED NOT NULL COMMENT '是否有生日特权:1 是 0 否'")
    private Integer isPriviledgeBirthday;

    @Column(name = "free_freight_point", columnDefinition = "DECIMAL(15,2) UNSIGNED NOT NULL COMMENT '免运费标准'")
    private BigDecimal freeFreightPoint;

    @Column(name = "remark", columnDefinition = "VARCHAR(200) DEFAULT '' COMMENT '备注'")
    private String remark;
}
