package com.lingyi.mall.biz.product.service.impl;

import com.lingyi.mall.biz.product.dao.mapper.SpuAttributeMapper;
import com.lingyi.mall.biz.product.dao.repository.SpuAttributeRepository;
import com.lingyi.mall.biz.product.model.dto.SpuAttributeDTO;
import com.lingyi.mall.biz.product.model.entity.SpuAttributeDO;
import com.lingyi.mall.biz.product.model.query.SpuAttributeQuery;
import com.lingyi.mall.biz.product.model.vo.SpuAttributeVO;
import com.lingyi.mall.biz.product.service.SpuAttributeService;
import com.lingyi.mall.common.orm.util.BaseServiceProImpl;

/**
 * @Author: maweiyan
 * @Email: 1107201045@qq.com
 * @DateTime: 2023/12/1 14:31
 * @Description:
 */
public class SpuAttributeServiceImpl extends BaseServiceProImpl<SpuAttributeRepository, SpuAttributeMapper, SpuAttributeDTO,
        SpuAttributeVO, SpuAttributeQuery, SpuAttributeDO, Long> implements SpuAttributeService {
}
