package com.lingyi.mall.api.system.param;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

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
public class UserParam implements Serializable {

    @Serial
    private static final long serialVersionUID = -6667153465937041097L;

    @Schema(description = "用户名称")
    private String userName;
}
