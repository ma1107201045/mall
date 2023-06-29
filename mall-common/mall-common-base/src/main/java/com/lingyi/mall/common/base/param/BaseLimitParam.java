package com.lingyi.mall.common.base.param;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serial;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/6/29 13:06
 * @description
 */
@Schema(description = "limit")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public abstract class BaseLimitParam extends BasePageParam {
    @Serial
    private static final long serialVersionUID = 7987432903456059366L;

    @Schema(description = "索引", hidden = true)
    private Integer index;

    @Schema(description = "数量", hidden = true)
    private Integer limit;

    /**
     * 抓换分页信息
     */
    public void convert() {
        this.setIndex((this.getCurrentPage() - 1) * this.getPageSize());
        this.setLimit(this.getPageSize());
    }
}
