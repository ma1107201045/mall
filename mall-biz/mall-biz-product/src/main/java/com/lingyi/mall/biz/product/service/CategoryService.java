package com.lingyi.mall.biz.product.service;

import com.lingyi.mall.biz.product.dto.CategoryDTO;
import com.lingyi.mall.biz.product.dto.SkuDTO;
import com.lingyi.mall.biz.product.entity.CategoryDO;
import com.lingyi.mall.biz.product.entity.SkuDO;
import com.lingyi.mall.biz.product.param.CategoryParam;
import com.lingyi.mall.biz.product.param.SkuParam;
import com.lingyi.mall.biz.product.vo.CategoryVO;
import com.lingyi.mall.biz.product.vo.SkuVO;
import com.lingyi.mall.common.orm.param.BasePageParam;
import com.lingyi.mall.common.orm.util.BaseService;
import com.lingyi.mall.common.orm.util.BaseServicePro;

/**
 * @Author: maweiyan
 * @Email: 1107201045@qq.com
 * @DateTime: 2023/8/31 9:51
 * @Description:
 */
public interface CategoryService extends BaseServicePro<CategoryDTO, CategoryVO, CategoryParam, CategoryDO, Long> {
}
