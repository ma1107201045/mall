package com.lingyi.mall.common.base.util;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

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

    @Schema(description = "成功标志（tue 成功 false 失败）", example = "true")
    private Boolean isSuccess;

    @Schema(description = "状态码", example = "200")
    private Integer code;

    @Schema(description = "信息", example = "成功")
    private String message;

    @Schema(description = "数据", example = "对象 or 数组")
    private T data;

    @Schema(description = "总条数", example = "1000L")
    private Long total;

    public static <T> ServerResponse<T> success(T data, Long total) {
        return new ServerResponse<>(Boolean.TRUE, HttpStatus.OK.value(), HttpStatus.OK.getReasonPhrase(), data, total);
    }

    public static <T> ServerResponse<T> success(T data) {
        return success(data, 0L);
    }

    public static <T> ServerResponse<T> success() {
        return success(ObjectUtil.getNull());
    }

    public static <T> ServerResponse<T> fail(Integer code, String message) {
        return new ServerResponse<>(Boolean.FALSE, code, message, ObjectUtil.getNull(), 0L);
    }

    public static <T> ServerResponse<T> fail(String message) {
        return fail(HttpStatus.INTERNAL_SERVER_ERROR.value(), message);
    }

    public static <T> ServerResponse<T> fail() {
        return fail(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase());
    }

}
