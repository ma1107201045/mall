package com.lingyi.mall.biz.product.service;

import com.lingyi.mall.biz.product.dto.AttributeDTO;
import com.lingyi.mall.biz.product.param.AttributeParam;
import com.lingyi.mall.biz.product.vo.AttributeVO;
import com.lingyi.mall.common.orm.util.BaseService;

/**
 * @Author: maweiyan
 * @Email: 1107201045@qq.com
 * @DateTime: 2023/8/31 9:46
 * @Description:
 */
public interface AttributeService extends BaseService<AttributeDTO, AttributeVO, AttributeParam, Long> {

    Long countByParam(AttributeParam attributeParam);
}
