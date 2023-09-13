package com.lingyi.mall.biz.product.service.impl;

import com.lingyi.mall.biz.product.converter.AttributeValueConverter;
import com.lingyi.mall.biz.product.dto.AttributeValueDTO;
import com.lingyi.mall.biz.product.entity.AttributeValueDO;
import com.lingyi.mall.biz.product.mapper.AttributeValueMapper;
import com.lingyi.mall.biz.product.param.AttributeValueParam;
import com.lingyi.mall.biz.product.repository.AttributeValueRepository;
import com.lingyi.mall.biz.product.service.AttributeValueService;
import com.lingyi.mall.biz.product.vo.AttributeValueVO;
import com.lingyi.mall.common.core.util.ConverterUtil;
import com.lingyi.mall.common.orm.util.BaseServiceProImpl;
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
public class AttributeValueServiceImpl extends BaseServiceProImpl<AttributeValueRepository, AttributeValueMapper, AttributeValueDTO, AttributeValueVO, AttributeValueParam, AttributeValueDO, Long>
        implements AttributeValueService {

    @Override
    public void createList(Long attributeId, List<String> names) {
        var attributeValues = AttributeValueConverter.INSTANCE.of(attributeId, names);
        jpaRepository.saveAll(attributeValues);
    }


    @Override
    public void deleteByAttributeIds(List<Long> attributeIds) {
        jpaRepository.deleteByAttributeIds(attributeIds);
    }
}
