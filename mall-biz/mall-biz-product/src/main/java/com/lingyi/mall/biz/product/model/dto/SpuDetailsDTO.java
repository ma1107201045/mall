package com.lingyi.mall.biz.product.model.dto;

import com.lingyi.mall.common.core.dto.BaseIdDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serial;

/**
 * @Author: maweiyan
 * @Email: 1107201045@qq.com
 * @DateTime: 2023/11/27 16:16
 * @Description:
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class SpuDetailsDTO extends BaseIdDTO<Long> {

    @Serial
    private static final long serialVersionUID = 5286694061016006137L;

    @Schema(description = "商品id")
    private Long spuId;

    @Schema(description = "商品内容")
    private String content;

}
