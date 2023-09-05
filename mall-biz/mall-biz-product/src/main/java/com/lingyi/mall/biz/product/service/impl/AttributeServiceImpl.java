package com.lingyi.mall.biz.product.service.impl;

import com.lingyi.mall.biz.product.dto.AttributeDTO;
import com.lingyi.mall.biz.product.entity.AttributeDO;
import com.lingyi.mall.biz.product.mapper.AttributeMapper;
import com.lingyi.mall.biz.product.param.AttributeParam;
import com.lingyi.mall.biz.product.repository.AttributeRepository;
import com.lingyi.mall.biz.product.service.AttributeService;
import com.lingyi.mall.biz.product.service.AttributeValueService;
import com.lingyi.mall.biz.product.vo.AttributeVO;
import com.lingyi.mall.common.base.util.ConverterUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author: maweiyan
 * @Email: 1107201045@qq.com
 * @DateTime: 2023/8/31 9:46
 * @Description:
 */
@Service
@RequiredArgsConstructor
public class AttributeServiceImpl implements AttributeService {

    private final AttributeRepository attributeRepository;

    private final AttributeMapper attributeMapper;

    private final AttributeValueService attributeValueService;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void create(AttributeDTO attributeDTO) {
        var attributeDO = ConverterUtil.to(attributeDTO, AttributeDO.class);
        //保存属性信息
        attributeRepository.save(attributeDO);
        //批量保存属性值信息
        attributeValueService.createList(attributeDO.getId(), attributeDTO.getAttributeValueNames());
    }

    @Override
    public void deleteByIds(List<Long> ids) {
        attributeRepository.deleteAllById(ids);
    }

    @Override
    public void updateById(AttributeDTO attributeDTO) {
        var optional = attributeRepository.findById(attributeDTO.getId());
        if (optional.isEmpty()) {
            return;
        }
        var attributeDO = optional.get();
        ConverterUtil.to(attributeDTO, attributeDO);
        attributeRepository.save(attributeDO);
    }

    @Override
    public AttributeVO readById(Long id) {
        return attributeMapper.selectById(id);
    }

    @Override
    public List<AttributeVO> readListByParam(AttributeParam attributeParam) {
        return attributeMapper.selectListByParam(attributeParam);
    }
}
