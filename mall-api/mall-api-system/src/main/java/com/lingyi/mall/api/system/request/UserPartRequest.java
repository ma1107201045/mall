package com.lingyi.mall.api.system.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/6/9 16:10
 * @description 用户
 */
@Data
@Schema(description = "部分用户")
public class UserPartRequest implements Serializable {


    @Serial
    private static final long serialVersionUID = 2571778543426443661L;

    @Schema(description = "用户id", requiredMode = Schema.RequiredMode.REQUIRED)
    private Long id;

    @Schema(description = "昵称")
    private String nickname;

    @Schema(description = "密码", requiredMode = Schema.RequiredMode.REQUIRED)
    private String password;
}