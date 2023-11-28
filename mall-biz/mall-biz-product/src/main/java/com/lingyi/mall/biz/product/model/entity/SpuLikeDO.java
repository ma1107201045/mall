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
 * @DateTime: 2023/11/28 9:56
 * @Description:
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Entity
@Table(name = "mp_spu_like")
@DynamicInsert
public class SpuLikeDO extends BaseIdDO<Long> implements Serializable {
    @Serial
    private static final long serialVersionUID = -7873839753610052350L;

    @ManyToOne(cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "spu_id", columnDefinition = "BIGINT(20) UNSIGNED NOT NULL COMMENT '商品id'",
            foreignKey = @ForeignKey(name = "mp_spu_like_fk_spu_id"))
    @OnDelete(action = OnDeleteAction.CASCADE)
    private SpuDO spuDO;

    @Column(name = "member_id", columnDefinition = "BIGINT(20) UNSIGNED NOT NULL COMMENT '会员id'")
    private Long memberId;

    @Column(name = "like_dataTime", columnDefinition = "BIGINT(20) UNSIGNED NOT NULL COMMENT '点赞时间'")
    private LocalDateTime likeDataTime;

}
