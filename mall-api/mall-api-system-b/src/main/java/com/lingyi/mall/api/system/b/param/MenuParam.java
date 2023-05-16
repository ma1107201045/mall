package com.lingyi.mall.api.system.b.param;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/5/16 15:59
 * @description
 */
@Schema(description = "菜单")
@Data
public class MenuParam implements Serializable {
    @Serial
    private static final long serialVersionUID = -2617029654030868799L;

}
