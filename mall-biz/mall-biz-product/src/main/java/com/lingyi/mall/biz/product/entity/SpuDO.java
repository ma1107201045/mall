package com.lingyi.mall.biz.product.entity;

import com.lingyi.mall.common.base.entity.BaseIsDeleteDO;
import jakarta.persistence.*;
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
 * @datetime 2023/6/9 14:25
 * @description
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Entity
@Table(name = "mp_spu")
@DynamicInsert
public class SpuDO extends BaseIsDeleteDO implements Serializable {
    @Serial
    private static final long serialVersionUID = -6759034725107108170L;

    @Column(name = "user_id", columnDefinition = "BIGINT(20) UNSIGNED NOT NULL COMMENT '用户id'")
    private Long userId;

    @Column(name = "merchant_id", columnDefinition = "BIGINT(20) UNSIGNED NOT NULL COMMENT '商家id'")
    private Long merchantId;

    @Column(name = "shop_id", columnDefinition = "BIGINT(20) UNSIGNED NOT NULL COMMENT '商铺id'")
    private Long shopId;

    @ManyToOne(cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "category_id", columnDefinition = "BIGINT(20) UNSIGNED NOT NULL COMMENT '分类id'", foreignKey = @ForeignKey(name = "fk_category_id"))
    private CategoryDO categoryDO;

    @Column(name = "name", columnDefinition = "VARCHAR(50) NOT NULL COMMENT '商品名称'")
    private String name;

    @Column(name = "services", columnDefinition = "VARCHAR(50) DEFAULT '' COMMENT '商品服务 1.无忧退货 2.快速退款 3.免费包邮'")
    private String services;

    @Column(name = "description", columnDefinition = "TEXT COMMENT '商品描述'")
    private String description;

    @Column(name = "details", columnDefinition = "TEXT COMMENT '商品详情'")
    private String details;

    @Column(name = "main_pic", columnDefinition = "VARCHAR(100) NOT NULL COMMENT '商品主图'")
    private String mainPic;

    @Column(name = "pics", columnDefinition = "VARCHAR(100) NOT NULL COMMENT '商品图片,多个图片,分割'")
    private String pics;

    @Column(name = "market_price", columnDefinition = "DECIMAL(10,2) UNSIGNED NOT NULL COMMENT '商品市场价'")
    private BigDecimal marketPrice;

    @Column(name = "sale_price", columnDefinition = "DECIMAL(10,2) UNSIGNED NOT NULL COMMENT '商品销售价'")
    private BigDecimal salePrice;

    @Column(name = "sale", columnDefinition = "INT(11) UNSIGNED DEFAULT 0 COMMENT '销售量'")
    private Integer sale;

    @Column(name = "total_stock", columnDefinition = "INT(11) UNSIGNED DEFAULT 0 COMMENT '总库存'")
    private Integer totalStock;

    @Column(name = "keywords", columnDefinition = "VARCHAR(200)  DEFAULT '' COMMENT '关键字（用于全文检索）'")
    private String keywords;

    @Column(name = "seq", columnDefinition = "INT(11) UNSIGNED DEFAULT 1 COMMENT '排序号'")
    private Integer seq;

    @Column(name = "is_up", columnDefinition = "TINYINT(4) UNSIGNED DEFAULT 0 COMMENT '是否上架 1是 0否'")
    private Integer isUp;


}
