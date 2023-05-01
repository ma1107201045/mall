package com.lingyi.mall.common.util;

import com.lingyi.mall.common.enums.BaseResponseEnum;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

/**
 * @author maiweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/05/01 18:52
 * @description
 */
@Data
@AllArgsConstructor
public class ServerResponse<T> implements Serializable {


    @Serial
    private static final long serialVersionUID = 8505044737530270464L;

    private Integer code;

    private String msg;

    private T data;


    public static <T> ServerResponse<T> success(T data) {
        return new ServerResponse<>(BaseResponseEnum.SUCCESS.getCode(), BaseResponseEnum.SUCCESS.getMsg(), data);
    }

    public static <T> ServerResponse<T> success() {
        return success(null);
    }

    public static <T> ServerResponse<T> fail(Integer code, String msg) {
        return new ServerResponse<>(code, msg, null);
    }

    public static <T> ServerResponse<T> fail(BaseResponseEnum response) {
        return fail(response.getCode(), response.getMsg());
    }

    public static <T> ServerResponse<T> fail() {
        return fail(BaseResponseEnum.FAIL);
    }
}
