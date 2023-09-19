package com.lingyi.mall.biz.file.exception;

import com.lingyi.mall.common.core.enums.BaseFailEnum;
import com.lingyi.mall.common.core.exception.BaseException;

import java.io.Serial;

/**
 * @Author: maweiyan
 * @Email 1107201045@qq.com
 * @DateTime: 2023/6/27 20:05
 * @Description:
 */
public class FileException extends BaseException {
    @Serial
    private static final long serialVersionUID = -6625681755495820665L;

    public FileException(BaseFailEnum baseFailEnum) {
        super(baseFailEnum);
    }

    public FileException(String message) {
        super(message);
    }

    public FileException(Integer code, String message) {
        super(code, message);
    }
}
