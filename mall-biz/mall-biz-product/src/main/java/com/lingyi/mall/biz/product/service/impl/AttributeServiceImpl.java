package com.lingyi.mall.biz.product.service.impl;

import com.lingyi.mall.biz.product.dto.AttributeDTO;
import com.lingyi.mall.biz.product.entity.AttributeDO;
import com.lingyi.mall.biz.product.mapper.AttributeMapper;
import com.lingyi.mall.biz.product.param.AttributeParam;
import com.lingyi.mall.biz.product.repository.AttributeRepository;
import com.lingyi.mall.biz.product.service.AttributeService;
import com.lingyi.mall.biz.product.service.AttributeValueService;
import com.lingyi.mall.biz.product.vo.AttributeVO;
import com.lingyi.mall.common.core.util.ConverterUtil;
import com.lingyi.mall.common.orm.util.BaseServiceProImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;

/**
 * @Author: maweiyan
 * @Email: 1107201045@qq.com
 * @DateTime: 2023/8/31 9:46
 * @Description:
 */
@Service
@RequiredArgsConstructor
public class AttributeServiceImpl extends BaseServiceProImpl<AttributeRepository, AttributeMapper, AttributeDTO, AttributeVO, AttributeParam, AttributeDO, Long>
        implements AttributeService {

    private final AttributeValueService attributeValueService;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void create(AttributeDTO attributeDTO) {
        //保存属性
        Long id = create(attributeDTO, AttributeDO.class);
        //批量保存属性值信息
        attributeValueService.createList(id, attributeDTO.getAttributeValueNames());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateById(AttributeDTO attributeDTO) {
        Long id = attributeDTO.getId();
        //保存属性
        super.updateById(attributeDTO);
        //批量删除属性值信息
        attributeValueService.deleteByAttributeIds(Collections.singletonList(id));
        //批量保存属性值信息
        attributeValueService.createList(id, attributeDTO.getAttributeValueNames());
    }


}
