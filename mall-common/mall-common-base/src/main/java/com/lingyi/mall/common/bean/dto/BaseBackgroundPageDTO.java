package com.lingyi.mall.common.bean.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/4/30 13:52
 * @description
 */
@Schema(description = "后台分页信息")
@Data
public class BaseBackgroundPageDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = -7930591841165119678L;

    @Schema(description = "页码", requiredMode = Schema.RequiredMode.NOT_REQUIRED, defaultValue = "1", example = "1")
    @Min(value = 1, message = "页码最小值有误")
    @Max(value = Integer.MAX_VALUE, message = "页码最大值有误")
    private Integer currentPage;

    @Schema(description = "页数", requiredMode = Schema.RequiredMode.NOT_REQUIRED, defaultValue = "10", example = "10")
    @Min(value = 1, message = "页数最小值有误")
    @Max(value = Integer.MAX_VALUE, message = "页数最大值有误")
    private Integer pageSize;
}