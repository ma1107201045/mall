package com.lingyi.mall.common.log.aspetct.annotation;

import com.lingyi.mall.common.log.enums.ClientTypeEnum;
import com.lingyi.mall.common.log.enums.OperationTypeEnum;

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

    String title() default "";

    OperationTypeEnum operationType() default OperationTypeEnum.OTHER;

    ClientTypeEnum clientType() default ClientTypeEnum.ADMIN;

    boolean ignoreParam() default false;
}
