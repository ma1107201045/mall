package com.lingyi.mall.biz.product.model.entity;

import com.lingyi.mall.common.orm.entity.BaseCommonDO;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.hibernate.annotations.DynamicInsert;

import java.io.Serial;
import java.io.Serializable;

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
public class SkuEvaluateCommentDO extends BaseCommonDO implements Serializable {

    @Serial
    private static final long serialVersionUID = 2332562569399458520L;

    private String content;
}
