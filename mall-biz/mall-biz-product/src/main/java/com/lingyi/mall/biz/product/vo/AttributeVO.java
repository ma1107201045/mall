package com.lingyi.mall.biz.product.vo;

import com.lingyi.mall.common.core.vo.BaseIdVO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serial;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @Author: maweiyan
 * @Email: 1107201045@qq.com
 * @DateTime: 2023/8/31 16:01
 * @Description:
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Schema(description = "属性")
public class AttributeVO extends BaseIdVO<Long> {

    @Serial
    private static final long serialVersionUID = 7708345973399103114L;

    @Schema(description = "商家id")
    private Long merchantId;

    @Schema(description = "商铺id")
    private Long shopId;

    @Schema(description = "用户id")
    private Long userId;

    @Schema(description = "属性名称")
    private String name;

    @Schema(description = "创建人")
    private String createBy;

    @Schema(description = "创建时间")
    private LocalDateTime createDateTime;

    @Schema(description = "最后一次更新人")
    private String lastModifyBy;

    @Schema(description = "最后一次更新时间")
    private LocalDateTime lastModifyDateTime;

    @Schema(description = "属性值名称")
    private List<String> attributeValueNames;
}
