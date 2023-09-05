package com.lingyi.mall.biz.product.service.impl;

import com.lingyi.mall.biz.product.converter.AttributeValueConverter;
import com.lingyi.mall.biz.product.entity.AttributeValueDO;
import com.lingyi.mall.biz.product.mapper.AttributeValueMapper;
import com.lingyi.mall.biz.product.param.AttributeValueParam;
import com.lingyi.mall.biz.product.repository.AttributeValueRepository;
import com.lingyi.mall.biz.product.service.AttributeValueService;
import com.lingyi.mall.biz.product.vo.AttributeValueVO;
import com.lingyi.mall.common.base.util.ConverterUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: maweiyan
 * @Email: 1107201045@qq.com
 * @DateTime: 2023/8/31 9:48
 * @Description:
 */
@Service
@RequiredArgsConstructor
public class AttributeValueServiceImpl implements AttributeValueService {


    private final AttributeValueRepository attributeValueRepository;

    private final AttributeValueMapper attributeValueMapper;

    @Override
    public void create(AttributeValueDO attributeValueDO) {
        attributeValueRepository.save(attributeValueDO);
    }

    @Override
    public void deleteByIds(List<Long> ids) {
        attributeValueRepository.deleteAllById(ids);
    }

    @Override
    public void updateById(AttributeValueDO attributeValueDO) {
        var optional = attributeValueRepository.findById(attributeValueDO.getId());
        if (optional.isEmpty()) {
            return;
        }
        var newAttributeValueDO = optional.get();
        ConverterUtil.to(attributeValueDO, newAttributeValueDO);
        attributeValueRepository.save(newAttributeValueDO);
    }

    @Override
    public AttributeValueVO readById(Long id) {
        return attributeValueMapper.selectById(id);
    }

    @Override
    public List<AttributeValueVO> readListByParam(AttributeValueParam attributeValueParam) {
        return attributeValueMapper.selectListByParam(attributeValueParam);
    }


    @Override
    public void createList(Long attributeId, List<String> attributeValueNames) {
        var attributeValues = attributeValueNames.stream()
                .map(name -> AttributeValueConverter.INSTANCE.of(attributeId, name))
                .toList();
        attributeValueRepository.saveAll(attributeValues);
    }
}
