package com.lingyi.mall.biz.product.model.dto;

import com.lingyi.mall.common.core.dto.BaseIdDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serial;

/**
 * @Author: maweiyan
 * @Email: 1107201045@qq.com
 * @DateTime: 2023/8/31 16:02
 * @Description:
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class SkuDTO extends BaseIdDTO<Long> {
    @Serial
    private static final long serialVersionUID = -7399959444673481949L;

}
