package com.lingyi.mall.biz.product.enums;

import com.lingyi.mall.common.core.enums.BaseFailEnum;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * @Author: maweiyan
 * @Email 1107201045@qq.com
 * @DateTime: 2023/5/7 17:27
 * @Description:
 */
@Getter
@RequiredArgsConstructor
public enum ProductFailEnum implements BaseFailEnum {

    /**
     *
     */
    CATEGORY_LEVEL_ERROR(8001, "分类等级错误");


    private final Integer code;

    private final String message;
}
