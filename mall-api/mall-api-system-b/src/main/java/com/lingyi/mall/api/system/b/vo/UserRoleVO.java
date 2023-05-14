package com.lingyi.mall.api.system.b.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @Author: maweiyan
 * @Email 1107201045@qq.com
 * @DateTime: 2023/5/14 19:50
 * @Description:
 */
@Data
public class UserRoleVO implements Serializable {
    @Serial
    private static final long serialVersionUID = 1616952137360080109L;

    @Schema(description = "用户角色id")
    private Long userRoleId;

    @Schema(description = "用户id")
    private Long userId;

    @Schema(description = "角色id")
    private Long roleId;

    @Schema(description = "创建人")
    private String createBy;

    @Schema(description = "创建时间")
    private LocalDateTime createDateTime;

    @Schema(description = "最后一次更新人")
    private String lastModifyBy;

    @Schema(description = "最后一次更新时间")
    private LocalDateTime lastModifyDateTime;

    @Schema(description = "是否删除 1是 0否")
    private Integer isDelete;
}
