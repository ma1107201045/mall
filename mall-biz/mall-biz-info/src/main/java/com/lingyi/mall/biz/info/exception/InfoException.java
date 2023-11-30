package com.lingyi.mall.biz.info.exception;

import com.lingyi.mall.common.core.enums.BaseFailEnum;
import com.lingyi.mall.common.core.exception.BaseException;

import java.io.Serial;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/7/14 14:57
 * @description
 */
public class InfoException extends BaseException {
    @Serial
    private static final long serialVersionUID = -5093391015522363653L;

    public InfoException(BaseFailEnum baseFailEnum) {
        super(baseFailEnum);
    }

    public InfoException(String message) {
        super(message);
    }

    public InfoException(Integer code, String message) {
        super(code, message);
    }
}
