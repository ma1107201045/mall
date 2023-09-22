package com.lingyi.mall.biz.product.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.lingyi.mall.common.core.vo.BaseIdVO;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serial;
import java.time.LocalDateTime;
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
@Schema(description = "分类")
public class CategoryVO extends BaseIdVO<Long> {
    @Serial
    private static final long serialVersionUID = -1128091138999932809L;

    @Schema(description = "用户id")
    private Long userId;

    @Schema(description = "商家id")
    private Long merchantId;

    @Schema(description = "商铺id")
    private Long shopId;

    @Schema(description = "父级id")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long parentId;

    @Schema(description = "分类名称")
    private String name;

    @Schema(description = "商品描述")
    private String description;

    @Schema(description = "分类图标")
    private String icon;

    @Schema(description = "分类级别")
    private Integer level;

    @Schema(description = "是否显示在导航栏 1是 0否")
    private Integer isShowNav;

    @Schema(description = "关键字（用于全文检索）")
    private String keywords;

    @Schema(description = "分类顺序")
    private Integer sort;

    @Schema(description = "是否启用 1 是 0 否")
    private Integer isEnable;

    @Schema(description = "创建人")
    private String createBy;

    @Schema(description = "创建时间")
    private LocalDateTime createDateTime;

    @Schema(description = "最后一次更新人")
    private String lastModifyBy;

    @Schema(description = "最后一次更新时间")
    private LocalDateTime lastModifyDateTime;

    @Schema(description = "菜单子级")
    private List<CategoryVO> children;
}
