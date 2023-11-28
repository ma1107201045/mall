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
import java.math.BigDecimal;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/6/16 14:16
 * @description
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Entity
@Table(name = "mp_sku")
@DynamicInsert
public class SkuDO extends BaseCommonDO implements Serializable {
    @Serial
    private static final long serialVersionUID = -8717730792380645075L;

    @Column(name = "user_id", columnDefinition = "BIGINT(20) UNSIGNED NOT NULL COMMENT '用户id'")
    private Long userId;

    @Column(name = "merchant_id", columnDefinition = "BIGINT(20) UNSIGNED NOT NULL COMMENT '商家id'")
    private Long merchantId;

    @Column(name = "shop_id", columnDefinition = "BIGINT(20) UNSIGNED NOT NULL COMMENT '商铺id'")
    private Long shopId;

    @ManyToOne(cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "spu_id", columnDefinition = "BIGINT(20) UNSIGNED NOT NULL COMMENT '商品id'",
            foreignKey = @ForeignKey(name = "mp_sku_fk_spu_id"))
    @OnDelete(action = OnDeleteAction.CASCADE)
    private SpuDO spuDO;

    @Column(name = "sn", columnDefinition = "VARCHAR(50) NOT NULL COMMENT 'SKU编号'")
    private String sn;

    @Column(name = "name", columnDefinition = "VARCHAR(255) NOT NULL COMMENT 'SKU名称'")
    private String name;

    @Column(name = "pic", columnDefinition = "VARCHAR(100) NOT NULL COMMENT 'SKU图片'")
    private String pic;

    @Column(name = "market_price", columnDefinition = "DECIMAL(10,2) UNSIGNED NOT NULL COMMENT 'SKU市场价'")
    private BigDecimal marketPrice;

    @Column(name = "sale_price", columnDefinition = "DECIMAL(10,2) UNSIGNED NOT NULL COMMENT 'SKU销售价'")
    private BigDecimal salePrice;

    @Column(name = "cost_price", columnDefinition = "DECIMAL(10,2) UNSIGNED NOT NULL COMMENT 'SKU成本价'")
    private BigDecimal costPrice;

    @Column(name = "vip_price", columnDefinition = "DECIMAL(10,2) UNSIGNED NOT NULL COMMENT 'SKUVIP价'")
    private BigDecimal vipPrice;

    @Column(name = "weight", columnDefinition = "DECIMAL(10,2) UNSIGNED NOT NULL COMMENT 'SKU重量'")
    private BigDecimal weight;

    @Column(name = "volume", columnDefinition = "DECIMAL(10,2) UNSIGNED NOT NULL COMMENT 'SKU体积'")
    private BigDecimal volume;

    @Column(name = "stock", columnDefinition = "INT(11) UNSIGNED DEFAULT 0 COMMENT 'SKU库存'")
    private Integer stock;

    @Column(name = "original_data", columnDefinition = "VARCHAR(255) NOT NULL COMMENT '原始数据(json格式)'")
    private String originalData;

}
