package com.lingyi.mall.common.bean.param;

import com.lingyi.mall.common.bean.constant.BaseConstant;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
public class BasePageParam implements Serializable {

    @Serial
    private static final long serialVersionUID = -7930591841165119678L;

    @Schema(description = "页码", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @Min(value = 1, message = "页码最小值有误")
    @Max(value = Integer.MAX_VALUE, message = "页码最大值有误")
    @NotNull(message = "页码不能为空")
    private Integer currentPage;

    @Schema(description = "页数", requiredMode = Schema.RequiredMode.REQUIRED, example = "10")
    @Min(value = 1, message = "页数最小值有误")
    @Max(value = Integer.MAX_VALUE, message = "页数最大值有误")
    @NotNull(message = "页数不能为空")
    private Integer pageSize;

    @Schema(description = "排序字段", requiredMode = Schema.RequiredMode.REQUIRED, example = "id")
    @NotBlank(message = "排序字段不能为空")
    private String sortField;

    @Schema(description = "排序方向", requiredMode = Schema.RequiredMode.REQUIRED, example = "DESC")
    @NotBlank(message = "排序不能为空")
    private String sortDirection;

    public String getSort() {
        return sortField + BaseConstant.SPACE_CHAR + sortDirection;
    }

    public static BasePageParam getEmpty() {
        return new BasePageParam();
    }
}
