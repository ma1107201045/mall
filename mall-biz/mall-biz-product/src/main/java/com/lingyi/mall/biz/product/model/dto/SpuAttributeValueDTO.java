package com.lingyi.mall.biz.product.model.dto;

import com.lingyi.mall.common.core.dto.BaseIdDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serial;

/**
 * @Author: maweiyan
 * @Email: 1107201045@qq.com
 * @DateTime: 2023/10/27 12:16
 * @Description:
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class SpuAttributeValueDTO extends BaseIdDTO<Long> {

    @Serial
    private static final long serialVersionUID = -703421601638555304L;
}
