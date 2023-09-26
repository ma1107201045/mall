package com.lingyi.mall.biz.product.dto;

import com.lingyi.mall.common.core.dto.BaseIdDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serial;
import java.time.LocalDateTime;
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
@Schema(description = "分类")
public class CategoryDTO extends BaseIdDTO<Long> {
    @Serial
    private static final long serialVersionUID = -2855543291448125145L;

    @Schema(description = "用户id")
    private Long userId;

    @Schema(description = "商家id")
    private Long merchantId;

    @Schema(description = "商铺id")
    private Long shopId;

    @Schema(description = "父级id")
    private Long parentId;

    @Schema(description = "分类名称", requiredMode = Schema.RequiredMode.REQUIRED)
    private String name;

    @Schema(description = "分类图标")
    private String icon;

    @Schema(description = "分类顺序")
    private Integer sort;

    @Schema(description = "分类级别")
    private Integer level;

    @Schema(description = "是否显示在导航栏 1是 0否")
    private Integer isShowNav;

    @Schema(description = "关键字（用于全文检索）")
    private String keywords;

    @Schema(description = "是否启用 1 是 0 否", requiredMode = Schema.RequiredMode.REQUIRED)
    private Integer isEnable;

    @Schema(description = "分类描述")
    private String description;

    @Schema(description = "属性集")
    @NotNull(message = "属性集不能为空")
    @Size(min = 1, message = "属性集不能为空")
    private List<Long> attributeIds;

}
