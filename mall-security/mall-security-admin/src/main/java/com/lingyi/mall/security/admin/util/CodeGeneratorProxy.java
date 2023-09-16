package com.lingyi.mall.security.admin.util;

import cn.hutool.captcha.generator.CodeGenerator;
import cn.hutool.captcha.generator.MathGenerator;
import com.lingyi.mall.common.core.constant.BaseConstant;

import java.io.Serial;

/**
 * @Author: maweiyan
 * @Email 1107201045@qq.com
 * @DateTime: 2023/6/28 21:58
 * @Description:
 */
public class CodeGeneratorProxy implements CodeGenerator {
    @Serial
    private static final long serialVersionUID = 1052765497703020852L;
    private final CodeGenerator generator;

    public CodeGeneratorProxy(CodeGenerator generator) {
        this.generator = generator;
    }

    @Override
    public String generate() {
        var code = generator.generate();
        return generator instanceof MathGenerator ? code + BaseConstant.QUESTION_CHAR : code;
    }

    @Override
    public boolean verify(String code, String userInputCode) {
        return generator.verify(code, userInputCode);
    }
}
