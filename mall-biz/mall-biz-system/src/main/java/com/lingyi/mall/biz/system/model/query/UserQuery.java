package com.lingyi.mall.biz.system.model.query;

import com.lingyi.mall.common.core.query.BasePageQuery;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/5/12 11:19
 * @description
 */

@Schema(description = "用户")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class UserQuery extends BasePageQuery {
    
    @Schema(description = "用户名称")
    private String userName;

    @Schema(description = "手机号")
    private String phoneNumber;
}
