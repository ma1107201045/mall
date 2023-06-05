package com.lingyi.mall.common.base.aspect;

import com.lingyi.mall.common.base.enums.ClientType;
import com.lingyi.mall.common.base.enums.OperationType;

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

    OperationType operationType() default OperationType.OTHER;

    ClientType clientType() default ClientType.ADMIN;

    boolean ignoreParam() default false;
}
