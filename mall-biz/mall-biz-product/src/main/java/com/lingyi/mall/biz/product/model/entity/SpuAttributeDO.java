package com.lingyi.mall.biz.product.model.entity;

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
 * @Author: maweiyan
 * @Email: 1107201045@qq.com
 * @DateTime: 2023/10/27 12:15
 * @Description:
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Entity
@Table(name = "mp_spu_attribute")
@DynamicInsert
public class SpuAttributeDO extends BaseCommonDO implements Serializable {

    @Serial
    private static final long serialVersionUID = -6290472354314280737L;

    @Column(name = "merchant_id", columnDefinition = "BIGINT(20) UNSIGNED NOT NULL COMMENT '商家id'")
    private Long merchantId;

    @Column(name = "shop_id", columnDefinition = "BIGINT(20) UNSIGNED NOT NULL COMMENT '商铺id'")
    private Long shopId;

    @Column(name = "user_id", columnDefinition = "BIGINT(20) UNSIGNED NOT NULL COMMENT '用户id'")
    private Long userId;

    @ManyToOne(cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "spu_id", columnDefinition = "BIGINT(20) UNSIGNED NOT NULL COMMENT '商品id'", foreignKey = @ForeignKey(name = "mp_spu_attribute_fk_spu_id"))
    @OnDelete(action = OnDeleteAction.CASCADE)
    private SpuDO spuDO;

    @Column(name = "name", columnDefinition = "VARCHAR(20) NOT NULL COMMENT '属性名称'")
    private String name;

}
