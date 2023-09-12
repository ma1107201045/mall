package com.lingyi.mall.biz.product.dto;

import com.lingyi.mall.common.orm.dto.BaseIdDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

/**
 * @Author: maweiyan
 * @Email: 1107201045@qq.com
 * @DateTime: 2023/8/31 16:03
 * @Description:
 */

@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Schema(description = "属性")
public class AttributeDTO extends BaseIdDTO<Long> {

    @Serial
    private static final long serialVersionUID = 1685677374901217723L;

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
