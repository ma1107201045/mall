package com.lingyi.mall.common.orm.vo;

import io.swagger.v3.oas.annotations.media.Schema;

import java.io.Serial;
import java.io.Serializable;

/**
 * @Author: maweiyan
 * @Email: 1107201045@qq.com
 * @DateTime: 2023/9/9 11:26
 * @Description:
 */
public abstract class BaseIdVO<ID> implements Serializable {

    @Serial
    private static final long serialVersionUID = -3848680408431067011L;
    @Schema(description = "主键id")
    private ID id;
}
