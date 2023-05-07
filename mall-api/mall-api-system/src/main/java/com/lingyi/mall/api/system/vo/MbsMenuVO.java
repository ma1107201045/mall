package com.lingyi.mall.api.system.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/5/5 16:25
 * @description
 */
@Schema(description = "菜单")
@Data
public class MbsMenuVO implements Serializable {
    @Serial
    private static final long serialVersionUID = -7753690884211490825L;

    @Schema(description = "菜单id")
    private Long menuId;

    @Schema(description = "权限标识")
    private String permission;
}
