package com.lingyi.mall.biz.product.service.impl;

import com.lingyi.mall.biz.product.converter.CategoryAttributeConverter;
import com.lingyi.mall.biz.product.converter.SpuAttributeConverter;
import com.lingyi.mall.biz.product.dao.mapper.SpuAttributeMapper;
import com.lingyi.mall.biz.product.dao.repository.SpuAttributeRepository;
import com.lingyi.mall.biz.product.model.dto.SpuAttributeDTO;
import com.lingyi.mall.biz.product.model.entity.AttributeDO;
import com.lingyi.mall.biz.product.model.entity.SpuAttributeDO;
import com.lingyi.mall.biz.product.model.entity.SpuAttributeValueDO;
import com.lingyi.mall.biz.product.model.query.SpuAttributeQuery;
import com.lingyi.mall.biz.product.model.vo.SpuAttributeVO;
import com.lingyi.mall.biz.product.service.SpuAttributeService;
import com.lingyi.mall.biz.product.service.SpuAttributeValueService;
import com.lingyi.mall.common.orm.util.BaseServiceProImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: maweiyan
 * @Email: 1107201045@qq.com
 * @DateTime: 2023/12/1 14:31
 * @Description:
 */
@Service
public class SpuAttributeServiceImpl extends BaseServiceProImpl<SpuAttributeRepository, SpuAttributeMapper, SpuAttributeDTO,
        SpuAttributeVO, SpuAttributeQuery, SpuAttributeDO, Long> implements SpuAttributeService {


    @Override
    public List<Long> addBatch(Long spuId, List<SpuAttributeDTO> spuAttributeDTOList) {
        var spuAttributes = SpuAttributeConverter.INSTANCE.toSpuAttributeDOList(spuId, spuAttributeDTOList);
        return createList(spuAttributes);
    }

    @Override
    public void removeBySpuAttributeIds(List<Long> spuAttributeIds) {

    }
}
