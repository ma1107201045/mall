package com.lingyi.mall.common.base.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

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

    private final Integer bizCode;

    private final String message;

    public OpenFeignException(String message) {
        super(message);
        this.bizCode = HttpStatus.INTERNAL_SERVER_ERROR.value();
        this.message = message;
    }

    public OpenFeignException(Integer bizCode, String message) {
        super(message);
        this.bizCode = bizCode;
        this.message = message;
    }
}
