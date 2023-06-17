package com.lingyi.mall.common.base.util;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.lingyi.mall.common.base.param.BasePageParam;

/**
 * @Author: maweiyan
 * @Email 1107201045@qq.com
 * @DateTime: 2023/6/17 21:33
 * @Description:
 */
public class PageUtil {


    public static <T> Page<T> startPage(BasePageParam basePageParam) {
        return PageHelper.startPage(basePageParam.getCurrentPage(), basePageParam.getPageSize(), basePageParam.getSort());
    }

}
