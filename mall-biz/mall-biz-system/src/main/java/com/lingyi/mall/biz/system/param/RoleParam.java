package com.lingyi.mall.biz.system.param;

import com.lingyi.mall.common.base.param.BasePageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serial;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/5/15 14:22
 * @description
 */
@Schema(description = "角色")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class RoleParam extends BasePageParam {

    @Serial
    private static final long serialVersionUID = 7120127170693422674L;

    @Schema(description = "角色名称")
    private String name;
}
