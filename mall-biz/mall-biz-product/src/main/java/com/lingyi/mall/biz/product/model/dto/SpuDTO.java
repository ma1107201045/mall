package com.lingyi.mall.biz.product.model.dto;

import com.lingyi.mall.common.core.dto.BaseIdDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serial;
import java.math.BigDecimal;
import java.util.List;

/**
 * @Author: maweiyan
 * @Email: 1107201045@qq.com
 * @DateTime: 2023/8/31 16:02
 * @Description:
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Schema(description = "spu")
public class SpuDTO extends BaseIdDTO<Long> {

    @Serial
    private static final long serialVersionUID = -3933866554330445181L;

    @Schema(description = "品牌id", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "品牌id不能为空")
    private Long brandId;

    @Schema(description = "分类id", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "分类id不能为空")
    private Long categoryId;

    @Schema(description = "属性集", requiredMode = Schema.RequiredMode.REQUIRED)
    @Valid
    @NotNull(message = "属性集不能为空")
    @Size(min = 1, message = "属性集长度不能为0")
    private List<SpuAttributeDTO> spuAttributes;

    @Schema(description = "SKU集", requiredMode = Schema.RequiredMode.REQUIRED)
    @Valid
    @NotNull(message = "SKU集不能为空")
    @Size(min = 1, message = "SKU集长度不能为0")
    private List<SkuDTO> skus;

    @Schema(description = "商品名称", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotBlank(message = "商品名称不能为空")
    private String name;

    @Schema(description = "商品简介")
    private String brief;

    @Schema(description = "商品关键字")
    private String keywords;

    @Schema(description = "商品主图", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotBlank(message = "商品主图不能为空")
    private String mainPic;

    @Schema(description = "商品图片,多个图片,分割")
    private String pics;

    @Schema(description = "市场价", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "市场价不能为空")
    private BigDecimal marketPrice;

    @Schema(description = "销售价", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "销售价不能为空")
    private BigDecimal salePrice;

    @Schema(description = "成本价", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "成本价不能为空")
    private BigDecimal costPrice;

    @Schema(description = "VIP价", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "VIP价不能为空")
    private BigDecimal vipPrice;

    @Schema(description = "是否包邮 1是 0否", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "是否包邮不能为空")
    private BigDecimal isMail;

    @Schema(description = "包邮价", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "包邮价不能为空")
    private BigDecimal mailPrice;

    @Schema(description = "单位名", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "单位名为空")
    private String unitName;

    @Schema(description = "销售量")
    private Integer sale;

    @Schema(description = "总库存")
    private Integer totalStock;

    @Schema(description = "排序号")
    private Integer seq;

    @Schema(description = "是否上架 1是 0否")
    private Integer isUp;


}
