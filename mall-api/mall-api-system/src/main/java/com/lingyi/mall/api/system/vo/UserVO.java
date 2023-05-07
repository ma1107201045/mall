
package com.lingyi.mall.api.system.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

/**
 * @Author: maweiyan
 * @Email 1107201045@qq.com
 * @DateTime: 2023/5/3 21:32
 * @Description:
 */
@Schema(description = "用户")
@Data
public class UserVO implements Serializable {
    @Serial
    private static final long serialVersionUID = 1243838317263367362L;

    @Schema(description = "用户id")
    private Long userId;

    @Schema(description = "密码")
    private String password;

    @Schema(description = "是否启用 1 是 0 否")
    private Integer isEnable;

    @Schema(description = "菜单列表")
    private List<MenuVO> menuVOList;

}
