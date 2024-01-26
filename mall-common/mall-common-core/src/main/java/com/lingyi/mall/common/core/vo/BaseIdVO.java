package com.lingyi.mall.common.core.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

/**
 * @Author: maweiyan
 * @Email: 1107201045@qq.com
 * @DateTime: 2023/9/9 11:26
 * @Description:
 */
@Data
public abstract class BaseIdVO<ID extends Number> implements Serializable {

    @Serial
    private static final long serialVersionUID = -3848680408431067011L;

    @Schema(description = "主键id")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private ID id;
}
