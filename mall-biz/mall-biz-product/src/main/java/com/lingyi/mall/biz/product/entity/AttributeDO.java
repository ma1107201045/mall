package com.lingyi.mall.biz.product.entity;

import com.lingyi.mall.common.jdbc.entity.BaseCommonDO;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.hibernate.annotations.DynamicInsert;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Entity
@Table(name = "mp_attribute")
@DynamicInsert
public class AttributeDO extends BaseCommonDO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1307758237932556955L;

    @Column(name = "merchant_id", columnDefinition = "BIGINT(20) UNSIGNED NOT NULL COMMENT '商家id'")
    private Long merchantId;

    @Column(name = "shop_id", columnDefinition = "BIGINT(20) UNSIGNED NOT NULL COMMENT '商铺id'")
    private Long shopId;

    @Column(name = "user_id", columnDefinition = "BIGINT(20) UNSIGNED NOT NULL COMMENT '用户id'")
    private Long userId;

    @Column(name = "name", columnDefinition = "VARCHAR(20) NOT NULL COMMENT '属性名称'")
    private String name;

    /**
     * 分类集
     */
    @ToString.Exclude
    @ManyToMany
    @JoinTable(name = "mp_category_attribute",
            joinColumns = @JoinColumn(name = "attribute_id"), inverseJoinColumns = @JoinColumn(name = "category_id"),
            foreignKey = @ForeignKey(name = "fk_attribute_id"), inverseForeignKey = @ForeignKey(name = "fk_category_id"),
            indexes = {@Index(name = "fk_attribute_id", columnList = "attribute_id"), @Index(name = "fk_category_id", columnList = "category_id")})
    private List<CategoryDO> categories;
}
