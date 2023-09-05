package com.lingyi.mall.biz.product.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @Author: maweiyan
 * @Email: 1107201045@qq.com
 * @DateTime: 2023/8/31 16:01
 * @Description:
 */
@Data
@Schema(description = "属性值")
public class AttributeValueVO {

    @Schema(description = "主键id")
    private Long id;

    @Schema(description = "属性值名称")
    private String name;


}
