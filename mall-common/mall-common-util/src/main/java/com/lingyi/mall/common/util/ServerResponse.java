package com.lingyi.mall.common.util;

import com.lingyi.mall.common.enums.BaseResponseEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

/**
 * @author maiweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/05/01 18:52
 * @description
 */
@Schema(description = "统一出参")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ServerResponse<T> implements Serializable {


    @Serial
    private static final long serialVersionUID = 8505044737530270464L;
    @Schema(description = "是否成功标志（tue 成功 false 失败）", example = "true")
    private Boolean isSuccess;

    @Schema(description = "状态码", example = "200")
    private Integer code;

    @Schema(description = "msg", example = "成功")
    private String msg;

    @Schema(description = "数据", example = "{} or []")
    private T data;


    public static <T> ServerResponse<T> success(T data) {
        return new ServerResponse<>(true, BaseResponseEnum.SUCCESS.getCode(), BaseResponseEnum.SUCCESS.getMsg(), data);
    }

    public static <T> ServerResponse<T> success() {
        return success(null);
    }

    public static <T> ServerResponse<T> fail(Integer code, String msg) {
        return new ServerResponse<>(false, code, msg, null);
    }

    public static <T> ServerResponse<T> fail(BaseResponseEnum response) {
        return fail(response.getCode(), response.getMsg());
    }

    public static <T> ServerResponse<T> fail() {
        return fail(BaseResponseEnum.FAIL);
    }
}
