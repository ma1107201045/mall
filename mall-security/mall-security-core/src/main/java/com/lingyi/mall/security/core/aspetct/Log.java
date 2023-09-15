package com.lingyi.mall.security.core.aspetct;

import com.lingyi.mall.common.core.constant.BaseConstant;
import com.lingyi.mall.common.core.enums.ClientTypeEnum;
import com.lingyi.mall.common.core.enums.OperationTypeEnum;

import java.lang.annotation.*;

/**
 * @Author: maweiyan
 * @Email 1107201045@qq.com
 * @DateTime: 2023/6/3 14:55
 * @Description:
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Log {

    String title() default BaseConstant.EMPTY_CHAR;

    OperationTypeEnum operationType() default OperationTypeEnum.OTHER;

    ClientTypeEnum clientType() default ClientTypeEnum.ADMIN;

    boolean ignoreParam() default false;
}
