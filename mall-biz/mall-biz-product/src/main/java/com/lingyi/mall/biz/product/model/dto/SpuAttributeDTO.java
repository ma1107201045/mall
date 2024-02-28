package com.lingyi.mall.biz.product.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.lingyi.mall.common.core.dto.BaseIdDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serial;
import java.util.List;

/**
 * @Author: maweiyan
 * @Email: 1107201045@qq.com
 * @DateTime: 2023/10/27 12:15
 * @Description:
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class SpuAttributeDTO extends BaseIdDTO<Long> {
    @Serial
    private static final long serialVersionUID = -9096831773485394963L;

    @Schema(description = "属性名称", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotBlank(message = "属性名称不能为空")
    private String name;

    @Schema(description = "属性值集", requiredMode = Schema.RequiredMode.REQUIRED)
    @Valid
    @NotNull(message = "属性值集不能为空")
    @Size(min = 1, message = "属性值集长度不能为0")
    @JsonProperty("spuAttributeValues")
    private List<SpuAttributeValueDTO> spuAttributeValueDTOList;
}
