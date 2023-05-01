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
public class BizException extends RuntimeException {


    @Serial
    private static final long serialVersionUID = -5427223280793906864L;
    private final Integer code;
    private final String msg;

    public BizException(String msg) {
        super(msg);
        this.code = BaseResponseEnum.FAIL.getCode();
        this.msg = msg;
    }

    public BizException(Integer code, String msg) {
        super(msg);
        this.code = code;
        this.msg = msg;
    }
}
