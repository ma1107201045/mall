package com.lingyi.mall.biz.product.service.impl;

import com.lingyi.mall.biz.product.converter.SpuAttributeValueConverter;
import com.lingyi.mall.biz.product.dao.mapper.SpuAttributeValueMapper;
import com.lingyi.mall.biz.product.dao.repository.SpuAttributeValueRepository;
import com.lingyi.mall.biz.product.model.dto.SpuAttributeDTO;
import com.lingyi.mall.biz.product.model.dto.SpuAttributeValueDTO;
import com.lingyi.mall.biz.product.model.entity.SpuAttributeValueDO;
import com.lingyi.mall.biz.product.model.query.SpuAttributeValueQuery;
import com.lingyi.mall.biz.product.model.vo.SpuAttributeValueVO;
import com.lingyi.mall.biz.product.service.SpuAttributeValueService;
import com.lingyi.mall.common.orm.util.BaseServiceProImpl;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.IntStream;

/**
 * @Author: maweiyan
 * @Email: 1107201045@qq.com
 * @DateTime: 2023/12/1 14:32
 * @Description:
 */
@Service
@RequiredArgsConstructor
public class SpuAttributeValueServiceImpl extends BaseServiceProImpl<SpuAttributeValueRepository, SpuAttributeValueMapper, SpuAttributeValueDTO,
        SpuAttributeValueVO, SpuAttributeValueQuery, SpuAttributeValueDO, Long> implements SpuAttributeValueService {

    @Override
    public void addBatch(List<Long> spuAttributeIdList, @NotNull List<SpuAttributeDTO> spuAttributeDTOList) {
        IntStream.range(0, spuAttributeDTOList.size())
                .forEach(i -> spuAttributeDTOList.get(i).setId(spuAttributeIdList.get(i)));

        var spuAttributeValues = SpuAttributeValueConverter.INSTANCE.toSpuAttributeValueDOList(spuAttributeDTOList);

        createList(spuAttributeValues);
    }
}
