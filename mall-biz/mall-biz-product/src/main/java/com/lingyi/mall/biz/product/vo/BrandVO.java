package com.lingyi.mall.biz.product.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @Author: maweiyan
 * @Email: 1107201045@qq.com
 * @DateTime: 2023/8/31 16:01
 * @Description:
 */
@Data
@Schema(description = "品牌")
public class BrandVO {

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

    @Schema(description = "创建人")
    private String createBy;

    @Schema(description = "创建时间")
    private LocalDateTime createDateTime;

    @Schema(description = "最后一次更新人")
    private String lastModifyBy;

    @Schema(description = "最后一次更新时间")
    private LocalDateTime lastModifyDateTime;
}
