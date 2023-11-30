package com.lingyi.mall.biz.product.model.dto;

import com.lingyi.mall.common.core.dto.BaseIdDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serial;

/**
 * @Author: maweiyan
 * @Email: 1107201045@qq.com
 * @DateTime: 2023/10/27 12:15
 * @Description:
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class SpuAttributeDTO extends BaseIdDTO<Long> {
    @Serial
    private static final long serialVersionUID = -9096831773485394963L;

}
