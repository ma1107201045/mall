package com.lingyi.mall.biz.system.model.param;

import com.lingyi.mall.common.core.param.BasePageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/6/29 15:32
 * @description
 */
@Schema(description = "日志")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class LogParam extends BasePageParam {

    @Schema(description = "标题")
    private String title;

    @Schema(description = "操作类型 1.创建 2.删除 3.更改 4.读取 5.其他")
    private Integer operationType;

    @Schema(description = "执行结果 1 成功 0 失败")
    private Integer executeResult;
}
