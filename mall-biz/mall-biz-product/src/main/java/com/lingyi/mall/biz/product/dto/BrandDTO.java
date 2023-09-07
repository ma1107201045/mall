package com.lingyi.mall.biz.product.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

/**
 * @Author: maweiyan
 * @Email: 1107201045@qq.com
 * @DateTime: 2023/8/31 16:03
 * @Description:
 */
@Schema(description = "品牌")
@Data
public class BrandDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = -6549591740358899349L;

    @Schema(description = "品牌id")
    private Long id;

    @Schema(description = "用户id")
    private Long userId;

    @Schema(description = "商家id")
    private Long merchantId;

    @Schema(description = "商铺id")
    private Long shopId;

    @Schema(description = "品牌名称")
    private String name;

    @Schema(description = "logo")
    private String logo;

    @Schema(description = "品牌首字母")
    private String firstCharacter;

    @Schema(description = "品牌主图")
    private String mainPic;
}
