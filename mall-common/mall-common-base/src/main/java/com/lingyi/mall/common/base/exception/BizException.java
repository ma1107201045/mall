package com.lingyi.mall.common.base.exception;

import com.lingyi.mall.common.base.enums.BaseFail;
import com.lingyi.mall.common.base.util.AssertUtil;
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
public class BizException extends RuntimeException {


    @Serial
    private static final long serialVersionUID = -5427223280793906864L;

    private final Integer bizCode;

    private final String message;

    public BizException(BaseFail baseFailEnum) {
        super((String) AssertUtil.getEnumMethodReturnValues(baseFailEnum)[1]);
        this.bizCode = (Integer) AssertUtil.getEnumMethodReturnValues(baseFailEnum)[0];
        this.message = (String) AssertUtil.getEnumMethodReturnValues(baseFailEnum)[1];
    }

    public BizException(String message) {
        super(message);
        this.bizCode = HttpStatus.INTERNAL_SERVER_ERROR.value();
        this.message = message;
    }

    public BizException(Integer bizCode, String message) {
        super(message);
        this.bizCode = bizCode;
        this.message = message;
    }
}
