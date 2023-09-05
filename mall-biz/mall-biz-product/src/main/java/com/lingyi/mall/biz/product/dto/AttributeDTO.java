package com.lingyi.mall.biz.product.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

/**
 * @Author: maweiyan
 * @Email: 1107201045@qq.com
 * @DateTime: 2023/8/31 16:03
 * @Description:
 */
@Data
@Schema(description = "属性")
public class AttributeDTO {

    @Schema(description = "品牌id")
    private Long id;

    @Schema(description = "用户id")
    private Long userId;

    @Schema(description = "商家id")
    private Long merchantId;

    @Schema(description = "商铺id")
    private Long shopId;

    @Schema(description = "属性名称")
    private String name;

    @Schema(description = "属性值集")
    private List<String> attributeValueNames;
}
