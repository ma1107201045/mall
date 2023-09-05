package com.lingyi.mall.biz.product.service;

import com.lingyi.mall.biz.product.dto.AttributeValueDTO;
import com.lingyi.mall.biz.product.entity.AttributeValueDO;
import com.lingyi.mall.biz.product.param.AttributeValueParam;
import com.lingyi.mall.biz.product.vo.AttributeValueVO;
import com.lingyi.mall.common.base.param.BasePageParam;
import com.lingyi.mall.common.base.util.BaseService;

import java.util.List;

/**
 * @Author: maweiyan
 * @Email: 1107201045@qq.com
 * @DateTime: 2023/8/31 9:48
 * @Description:
 */
public interface AttributeValueService extends BaseService<AttributeValueDO, AttributeValueParam, AttributeValueVO, Long> {

    void createList(Long attributeId, List<String> attributeValueNames);
}
