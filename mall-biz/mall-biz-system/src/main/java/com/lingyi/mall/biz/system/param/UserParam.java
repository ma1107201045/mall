package com.lingyi.mall.biz.system.param;

import com.lingyi.mall.common.base.param.BaseLimitParam;
import com.lingyi.mall.common.base.param.BasePageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serial;
import java.io.Serializable;

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
public class UserParam extends BaseLimitParam {

    @Serial
    private static final long serialVersionUID = -6667153465937041097L;

    @Schema(description = "用户名称")
    private String userName;

    @Schema(description = "手机号")
    private String phoneNumber;
}
