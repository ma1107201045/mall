package com.lingyi.mall.biz.product.model.entity;

import com.lingyi.mall.common.orm.entity.BaseCommonDO;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.hibernate.annotations.DynamicInsert;

import java.io.Serial;
import java.io.Serializable;

/**
 * @Author: maweiyan
 * @Email: 1107201045@qq.com
 * @DateTime: 2023/8/31 16:03
 * @Description:
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Entity
@Table(name = "mp_attribute_value")
@DynamicInsert
public class AttributeValueDO extends BaseCommonDO implements Serializable {

    @Serial
    private static final long serialVersionUID = 5137114203291281971L;

    @Column(name = "user_id", columnDefinition = "BIGINT(20) UNSIGNED NOT NULL COMMENT '用户id'")
    private Long userId;

    @Column(name = "merchant_id", columnDefinition = "BIGINT(20) UNSIGNED NOT NULL COMMENT '商家id'")
    private Long merchantId;

    @Column(name = "shop_id", columnDefinition = "BIGINT(20) UNSIGNED NOT NULL COMMENT '商铺id'")
    private Long shopId;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REMOVE}, fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "attribute_id", columnDefinition = "BIGINT(20) UNSIGNED NOT NULL COMMENT '属性id'", foreignKey = @ForeignKey(name = "mp_attribute_value_fk_attribute_id"))
    private AttributeDO attributeDO;

    @Column(name = "name", columnDefinition = "VARCHAR(20) NOT NULL COMMENT '属性值名称'")
    private String name;
}
