package com.lingyi.mall.biz.product.model.dto;

import com.lingyi.mall.common.core.dto.BaseIdDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serial;

/**
 * @Author: maweiyan
 * @Email: 1107201045@qq.com
 * @DateTime: 2023/10/27 12:16
 * @Description:
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class SpuAttributeValueDTO extends BaseIdDTO<Long> {
    @Serial
    private static final long serialVersionUID = -703421601638555304L;


    @Schema(description = "属性值名称", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotBlank(message = "属性值名称不能为空")
    private String name;
}
