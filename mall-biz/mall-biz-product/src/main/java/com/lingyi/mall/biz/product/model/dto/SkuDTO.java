package com.lingyi.mall.biz.product.model.dto;

import com.lingyi.mall.biz.product.model.entity.SpuDO;
import com.lingyi.mall.common.core.dto.BaseIdDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.io.Serial;
import java.math.BigDecimal;

/**
 * @Author: maweiyan
 * @Email: 1107201045@qq.com
 * @DateTime: 2023/8/31 16:02
 * @Description:
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Schema(description = "SKU")
public class SkuDTO extends BaseIdDTO<Long> {
    @Serial
    private static final long serialVersionUID = -7399959444673481949L;


    @Schema(description = "spuId", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "spuId不能为空")
    private Long spuId;

    @Schema(description = "SKU编号", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotBlank(message = "spuId不能为空")
    private String sn;

    @Schema(description = "SKU名称", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotBlank(message = "SKU名称不能为空")
    private String name;

    @Schema(description = "SKU图片", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotBlank(message = "SKU图片不能为空")
    private String pic;

    @Schema(description = "市场价", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "市场价不能为空")
    private BigDecimal marketPrice;

    @Schema(description = "销售价")
    private BigDecimal salePrice;

    @Schema(description = "成本价", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "成本价不能为空")
    private BigDecimal costPrice;

    @Schema(description = "VIP价", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "VIP价不能为空")
    private BigDecimal vipPrice;

    @Schema(description = "SKU重量", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "SKU重量不能为空")
    private BigDecimal weight;

    @Schema(description = "SKU体积", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "SKU体积不能为空")
    private BigDecimal volume;

    @Schema(description = "SKU库存", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "SKU库存不能为空")
    private Integer stock;

    @Schema(description = "原始数据(json格式)", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotBlank(message = "原始数据(json格式)不能为空")
    private String originalData;
}
