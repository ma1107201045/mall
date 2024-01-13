package com.lingyi.mall.biz.system.model.query;

import com.lingyi.mall.common.core.query.BasePageQuery;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

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
public class RoleQuery extends BasePageQuery {

    @Schema(description = "角色名称")
    private String name;
}