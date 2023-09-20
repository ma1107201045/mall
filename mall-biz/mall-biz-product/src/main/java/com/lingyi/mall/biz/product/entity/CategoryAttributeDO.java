package com.lingyi.mall.biz.product.entity;

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
@Table(name = "mp_category_attribute")
@DynamicInsert
public class CategoryAttributeDO extends BaseCommonDO implements Serializable {

    @Serial
    private static final long serialVersionUID = 8325971574533299862L;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REMOVE}, fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "category_id", columnDefinition = "BIGINT(20) UNSIGNED NOT NULL COMMENT '分类id'")
    private CategoryDO categoryDO;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REMOVE}, fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "attribute_id", columnDefinition = "BIGINT(20) UNSIGNED NOT NULL COMMENT '属性id'")
    private AttributeDO attributeDO;
}
