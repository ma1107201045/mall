package com.lingyi.mall.biz.system.param;

import com.lingyi.mall.common.base.param.BasePageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/5/16 15:59
 * @description
 */
@Schema(description = "菜单")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class MenuParam extends BasePageParam {


    @Schema(description = "菜单名称")
    private String name;

}
