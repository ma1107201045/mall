package com.lingyi.mall.common.orm.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

/**
 * @Author: maweiyan
 * @Email: 1107201045@qq.com
 * @DateTime: 2023/9/9 9:42
 * @Description:
 */
@Data
public abstract class BaseIdDTO<ID> implements Serializable {

    @Serial
    private static final long serialVersionUID = 3559017198770861533L;

    @Schema(description = "主键id")
    private ID id;
}
