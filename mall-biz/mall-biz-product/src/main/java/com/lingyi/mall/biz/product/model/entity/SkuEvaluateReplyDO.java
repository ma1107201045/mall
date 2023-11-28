package com.lingyi.mall.biz.product.model.entity;

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
 * @DateTime: 2023/11/28 10:06
 * @Description:
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Entity
@Table(name = "mp_sku_evaluate_reply")
@DynamicInsert
public class SkuEvaluateReplyDO extends BaseIdDO<Long> implements Serializable {

    @Serial
    private static final long serialVersionUID = 8101696036425990741L;

    @ManyToOne(cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "comment_id", columnDefinition = "BIGINT(20) UNSIGNED NOT NULL COMMENT '评论id'",
            foreignKey = @ForeignKey(name = "mp_sku_evaluate_reply_fk_comment_id"))
    @OnDelete(action = OnDeleteAction.CASCADE)
    private SkuEvaluateCommentDO skuEvaluateCommentDO;

    @ManyToOne(cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "reply_id", columnDefinition = "BIGINT(20) UNSIGNED NOT NULL COMMENT '回复id'",
            foreignKey = @ForeignKey(name = "mp_sku_evaluate_reply_fk_reply_id"))
    @OnDelete(action = OnDeleteAction.CASCADE)
    private SkuEvaluateReplyDO skuEvaluateReplyDO;

    @Column(name = "member_id", columnDefinition = "BIGINT(20) UNSIGNED NOT NULL COMMENT '会员id'")
    private Long memberId;

    @Column(name = "content", columnDefinition = "VARCHAR(256) DEFAULT '' COMMENT '评论内容'")
    private String content;

    @Column(name = "reply_type", columnDefinition = "TINYINT(4) NOT NULL COMMENT '回复类型 1评论 2评论的回复'")
    private Integer replyType;

    @Column(name = "reply_date_time", columnDefinition = "DATETIME NOT NULL COMMENT '回复时间'")
    private LocalDateTime replyDateTime;
}
