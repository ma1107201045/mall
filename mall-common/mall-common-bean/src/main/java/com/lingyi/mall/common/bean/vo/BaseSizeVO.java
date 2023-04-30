package com.lingyi.mall.common.bean.vo;

import io.swagger.v3.oas.annotations.media.Schema;

import java.io.Serial;
import java.io.Serializable;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/4/30 14:05
 * @description
 */
public class BaseSizeVO implements Serializable {
    @Serial
    private static final long serialVersionUID = 2921743378145832753L;

    @Schema(name = "总记录数")
    private Long size;
}
