package com.lingyi.mall.common.core.vo;

import com.lingyi.mall.common.core.util.ObjectUtil;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

/**
 * @Author: maweiyan
 * @Email: 1107201045@qq.com
 * @DateTime: 2023/11/28 13:57
 * @Description:
 */
@Data
public class PageVO<T> implements Serializable {
    @Serial
    private static final long serialVersionUID = -7578349007799412333L;

    @Schema(description = "总条数", example = "1000L")
    private Long total;

    private T data;

    protected PageVO() {

    }

    protected PageVO(Long total, T data) {
        this.total = total;
        this.data = data;
    }

    public static <T> PageVO<T> build(Long total, T t) {
        return new PageVO<>(total, t);
    }

    public static PageVO<?> buildEmpty() {
        return new PageVO<>(0L, ObjectUtil.getNull());
    }
}
