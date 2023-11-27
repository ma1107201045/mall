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
 * @DateTime: 2023/11/27 16:16
 * @Description:
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Entity
@Table(name = "mp_spu_details")
@DynamicInsert
public class SpuDetailsDO extends BaseCommonDO implements Serializable {
    @Serial
    private static final long serialVersionUID = -7270713019467651028L;

    @ManyToOne(cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "spu_id", columnDefinition = "BIGINT(20) UNSIGNED NOT NULL COMMENT '商品id'", foreignKey = @ForeignKey(name = "mp_spu_details_fk_spu_id"))
    private SpuDO spuDO;

    @Column(name = "content", columnDefinition = "LONGTEXT COMMENT '内容'")
    private String content;

}
