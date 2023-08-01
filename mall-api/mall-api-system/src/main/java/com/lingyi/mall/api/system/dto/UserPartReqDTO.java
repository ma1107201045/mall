package com.lingyi.mall.api.system.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/6/9 16:10
 * @description
 */
@Schema(description = "用户")
@Data
public class UserPartReqDTO  {

    @Schema(description = "用户id")
    private Long id;

    @Schema(description = "昵称")
    private String nickname;

    @Schema(description = "密码")
    private String password;
}
