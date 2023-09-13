package com.lingyi.mall.biz.product.service;

import com.lingyi.mall.biz.product.dto.CategoryAttributeDTO;
import com.lingyi.mall.biz.product.entity.CategoryAttributeDO;
import com.lingyi.mall.biz.product.param.CategoryAttributeParam;
import com.lingyi.mall.biz.product.vo.CategoryAttributeVO;
import com.lingyi.mall.common.orm.param.BasePageParam;
import com.lingyi.mall.common.orm.util.BaseService;
import com.lingyi.mall.common.orm.util.BaseServicePro;

/**
 * @Author: maweiyan
 * @Email: 1107201045@qq.com
 * @DateTime: 2023/8/31 9:52
 * @Description:
 */
public interface CategoryAttributeService extends BaseServicePro<CategoryAttributeDTO, CategoryAttributeVO, CategoryAttributeParam, CategoryAttributeDO, Long> {
}
