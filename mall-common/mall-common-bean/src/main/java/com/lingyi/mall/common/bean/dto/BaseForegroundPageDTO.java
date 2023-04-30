package com.lingyi.mall.common.bean.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

import java.io.Serial;
import java.io.Serializable;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/4/30 13:55
 * @description
 */
public class BaseForegroundPageDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = -1740204284407483348L;

    @Schema(name = "最后记录id", requiredMode = Schema.RequiredMode.NOT_REQUIRED, defaultValue = "1", example = "1")
    @Min(value = 1L, message = "最后记录id最小值有误")
    @Max(value = Long.MAX_VALUE, message = "最后记录id最大值有误")
    private Long lastId;

    @Schema(name = "页数", requiredMode = Schema.RequiredMode.NOT_REQUIRED, defaultValue = "10", example = "10")
    @Min(value = 1L, message = "页数最小值有误")
    @Max(value = Long.MAX_VALUE, message = "页数最大值有误")
    private Long pageSize;
}
