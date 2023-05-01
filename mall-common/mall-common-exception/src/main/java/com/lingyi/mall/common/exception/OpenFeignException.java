package com.lingyi.mall.common.exception;

import com.lingyi.mall.common.enums.BaseResponseEnum;
import lombok.Getter;

import java.io.Serial;

/**
 * @author maiweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/05/01 18:52
 * @description
 */
@Getter
public class OpenFeignException extends RuntimeException {


    @Serial
    private static final long serialVersionUID = -3612965431558240914L;

    private final Integer code;

    private final String msg;

    public OpenFeignException(String msg) {
        super(msg);
        this.code = BaseResponseEnum.FAIL.getCode();
        this.msg = msg;
    }

    public OpenFeignException(Integer code, String msg) {
        super(msg);
        this.code = code;
        this.msg = msg;
    }
}
