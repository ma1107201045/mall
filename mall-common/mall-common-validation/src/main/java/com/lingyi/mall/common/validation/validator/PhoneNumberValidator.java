package com.lingyi.mall.common.validation.validator;

import cn.hutool.core.util.PhoneUtil;
import com.lingyi.mall.common.validation.annotation.PhoneNumber;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.stereotype.Component;

/**
 * @Author: maweiyan
 * @Email: 1107201045@qq.com
 * @DateTime: 2024/1/20 8:49
 * @Description:
 */
@Component
public class PhoneNumberValidator implements ConstraintValidator<PhoneNumber, String> {
    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        return PhoneUtil.isPhone(s);
    }
}
