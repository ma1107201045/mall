package com.lingyi.mall.api.system.b.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/5/15 14:35
 * @description
 */
@Schema(description = "角色菜单")
@Data
public class RoleMenuDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = 4953481066397131538L;

}
