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
 * @DateTime: 2023/11/28 10:05
 * @Description:
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Entity
@Table(name = "mp_sku_evaluate_comment")
@DynamicInsert
public class SkuEvaluateCommentDO extends BaseIdDO<Long> implements Serializable {

    @Serial
    private static final long serialVersionUID = 2332562569399458520L;

    @ManyToOne(cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "evaluate_id", columnDefinition = "BIGINT(20) UNSIGNED NOT NULL COMMENT '评价id'",
            foreignKey = @ForeignKey(name = "mp_sku_evaluate_comment_fk_evaluate_id"))
    @OnDelete(action = OnDeleteAction.CASCADE)
    private SkuEvaluateDO skuEvaluateDO;

    @Column(name = "member_id", columnDefinition = "BIGINT(20) UNSIGNED NOT NULL COMMENT '会员id'")
    private Long memberId;

    @Column(name = "content", columnDefinition = "VARCHAR(256) DEFAULT '' COMMENT '评论内容'")
    private String content;

    @Column(name = "comment_date_time", columnDefinition = "DATETIME NOT NULL COMMENT '评论时间'")
    private LocalDateTime commentDateTime;
}
