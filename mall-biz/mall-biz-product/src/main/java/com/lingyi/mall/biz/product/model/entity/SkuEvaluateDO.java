package com.lingyi.mall.biz.product.model.entity;

import com.lingyi.mall.common.orm.entity.BaseCommonDO;
import com.lingyi.mall.common.orm.entity.BaseIdDO;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @Author: maweiyan
 * @Email: 1107201045@qq.com
 * @DateTime: 2023/11/28 10:19
 * @Description:
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Entity
@Table(name = "mp_sku_evaluate")
@DynamicInsert
public class SkuEvaluateDO extends BaseIdDO<Long> implements Serializable {

    @Serial
    private static final long serialVersionUID = -1275452088660212443L;

    @ManyToOne(cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "spu_id", columnDefinition = "BIGINT(20) UNSIGNED NOT NULL COMMENT '商品id'",
            foreignKey = @ForeignKey(name = "mp_sku_evaluate_fk_spu_id"))
    @OnDelete(action = OnDeleteAction.CASCADE)
    private SpuDO spuDO;

    @ManyToOne(cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "sku_id", columnDefinition = "BIGINT(20) UNSIGNED NOT NULL COMMENT 'skuId'",
            foreignKey = @ForeignKey(name = "mp_sku_evaluate_fk_sku_id"))
    @OnDelete(action = OnDeleteAction.CASCADE)
    private SkuDO skuDO;

    @Column(name = "sku_name", columnDefinition = "BIGINT(20) UNSIGNED NOT NULL COMMENT 'sku名称'")
    private Long skuName;

    @Column(name = "order_id", columnDefinition = "BIGINT(20) UNSIGNED NOT NULL COMMENT '订单id'")
    private Long orderId;

    @Column(name = "member_id", columnDefinition = "BIGINT(20) UNSIGNED NOT NULL COMMENT '会员id'")
    private Long memberId;

    @Column(name = "pics", columnDefinition = "TEXT COMMENT '评价图片'")
    private String pics;

    @Column(name = "content", columnDefinition = "VARCHAR(200) DEFAULT '' COMMENT '评价内容'")
    private String content;

    @Column(name = "score", columnDefinition = "TINYINT(4) UNSIGNED NOT NULL COMMENT '分数'")
    private Integer score;

    @Column(name = "evaluate_date_time", columnDefinition = "DATETIME NOT NULL COMMENT '评价时间'")
    private LocalDateTime evaluateDateTime;

}
