package com.lingyi.mall.biz.product.model.entity;

import com.lingyi.mall.common.orm.entity.BaseCommonDO;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.hibernate.annotations.DynamicInsert;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

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

    @OneToMany(mappedBy = "attribute", fetch = FetchType.LAZY)
    private List<AttributeValueDO> attributeValues;

    @OneToMany(mappedBy = "attribute", fetch = FetchType.LAZY)
    @ToString.Exclude
    private List<CategoryAttributeDO> categoryAttributes;
}
