package com.lingyi.mall.biz.product.model.dto;

import com.lingyi.mall.biz.product.model.entity.SpuDO;
import com.lingyi.mall.common.core.dto.BaseIdDTO;
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
public class SpuLikeDTO extends BaseIdDTO<Long> {

    @Serial
    private static final long serialVersionUID = -1671241461165741210L;

}
