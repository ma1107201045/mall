package com.lingyi.mall.biz.sms.exception;

import com.lingyi.mall.common.base.enums.BaseFailEnum;
import com.lingyi.mall.common.base.exception.BizException;

import java.io.Serial;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/7/14 14:57
 * @description
 */
public class SmsException extends BizException {
    @Serial
    private static final long serialVersionUID = -5093391015522363653L;

    public SmsException(BaseFailEnum baseFailEnum) {
        super(baseFailEnum);
    }

    public SmsException(String message) {
        super(message);
    }

    public SmsException(Integer code, String message) {
        super(code, message);
    }
}
