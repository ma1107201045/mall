package com.lingyi.mall.common.base.param;

import com.lingyi.mall.common.base.constant.BaseConstant;
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
public class BasePageParam implements Serializable {

    @Serial
    private static final long serialVersionUID = 975629823646747916L;

    private static final Integer CURRENT_PAGE_DEFAULT_VALUE = 1;

    private static final Integer PAGE_SIZE_DEFAULT_VALUE = 10;

    private static final String SORT_FIELD_DEFAULT_VALUE = "id";

    private static final String SORT_DIRECTION_DEFAULT_VALUE = "DESC";

    @Schema(description = "页码", requiredMode = Schema.RequiredMode.NOT_REQUIRED, example = "1")
    @Min(value = 1, message = "页码最小值有误")
    @Max(value = Integer.MAX_VALUE, message = "页码最大值有误")
    private Integer currentPage = CURRENT_PAGE_DEFAULT_VALUE;

    @Schema(description = "页数", requiredMode = Schema.RequiredMode.NOT_REQUIRED, example = "10")
    @Min(value = 1, message = "页数最小值有误")
    @Max(value = Integer.MAX_VALUE, message = "页数最大值有误")
    private Integer pageSize = PAGE_SIZE_DEFAULT_VALUE;

    @Schema(description = "排序字段", requiredMode = Schema.RequiredMode.NOT_REQUIRED, example = "id")
    private String sortField = SORT_FIELD_DEFAULT_VALUE;

    @Schema(description = "排序方向", requiredMode = Schema.RequiredMode.NOT_REQUIRED, example = "DESC")
    private String sortDirection = SORT_DIRECTION_DEFAULT_VALUE;

    @Schema(description = "偏移量", hidden = true)
    private Integer offset;

    @Schema(description = "数量", hidden = true)
    private Integer limit;

    public Integer getOffset() {
        offset = (currentPage - 1) * pageSize;
        return offset;
    }

    public Integer getLimit() {
        limit = pageSize;
        return limit;
    }


    public String getSort() {
        return sortField + BaseConstant.SPACE_CHAR + sortDirection;
    }

}
