package com.lingyi.mall.biz.product.entity;

import com.lingyi.mall.common.base.entity.BaseCommonDO;
import com.lingyi.mall.common.base.entity.BaseIsDeleteDO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.hibernate.annotations.DynamicInsert;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/6/10 10:03
 * @description
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Entity
@Table(name = "mp_category")
@DynamicInsert
public class CategoryDO extends BaseCommonDO implements Serializable {
    @Serial
    private static final long serialVersionUID = 5024590028573249574L;

    @Column(name = "user_id", columnDefinition = "BIGINT(20) UNSIGNED NOT NULL COMMENT '用户id'")
    private Long userId;

    @Column(name = "merchant_id", columnDefinition = "BIGINT(20) UNSIGNED NOT NULL COMMENT '商家id'")
    private Long merchantId;

    @Column(name = "shop_id", columnDefinition = "BIGINT(20) UNSIGNED NOT NULL COMMENT '商铺id'")
    private Long shopId;

    @Column(name = "parent_id", columnDefinition = "BIGINT(20) UNSIGNED NOT NULL COMMENT '父级id'")
    private Long parentId;

    @Column(name = "name", columnDefinition = "VARCHAR(20) NOT NULL COMMENT '分类名称'")
    private String name;

    @Column(name = "description", columnDefinition = "TEXT COMMENT '商品描述'")
    private String description;

    @Column(name = "icon", columnDefinition = "VARCHAR(20) DEFAULT '' COMMENT '分类图标'")
    private String icon;

    @Column(name = "level", columnDefinition = "TINYINT(4) UNSIGNED NOT NULL COMMENT '分类级别'")
    private Integer level;

    @Column(name = "is_show_nav", columnDefinition = "TINYINT(4) UNSIGNED NOT NULL COMMENT '是否显示在导航栏 1是 0否'")
    private Integer isShowNav;

    @Column(name = "keywords", columnDefinition = "VARCHAR(200)  DEFAULT '' COMMENT '关键字（用于全文检索）'")
    private String keywords;

    @Column(name = "seq", columnDefinition = "INT(11) UNSIGNED DEFAULT 1 COMMENT '排序号'")
    private Integer seq;

    /**
     * 屬性集
     */
    @ManyToMany(mappedBy = "categories")
    private List<AttributeDO> attributes;
}
