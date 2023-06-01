package com.lingyi.mall.api.system.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

/**
 * @Author: maweiyan
 * @Email 1107201045@qq.com
 * @DateTime: 2023/6/1 22:31
 * @Description:
 */
@Schema(description = "用户")
@Data
public class UserPartDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = 1494543714894436563L;

    @Schema(description = "菜单id")
    private Long id;

    @Schema(description = "昵称")
    private String nickname;

    @Schema(description = "密码")
    private String password;
}
