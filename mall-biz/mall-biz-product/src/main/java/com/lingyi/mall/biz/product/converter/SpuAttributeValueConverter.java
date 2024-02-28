package com.lingyi.mall.biz.product.converter;

import com.lingyi.mall.biz.product.model.dto.SpuAttributeDTO;
import com.lingyi.mall.biz.product.model.entity.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author: maweiyan
 * @Email: 1107201045@qq.com
 * @DateTime: 2024/2/27 15:59
 * @Description:
 */
public final class SpuAttributeValueConverter {

    public static final SpuAttributeValueConverter INSTANCE = new SpuAttributeValueConverter();

    private SpuAttributeValueConverter() {

    }

    public SpuAttributeValueDO toSpuAttributeValueDO(Long spuId, Long spuAttributeId, String name) {
        var spudDO = new SpuDO();
        var spuAttributeDO = new SpuAttributeDO();
        var spuAttributeValueDO = new SpuAttributeValueDO();
        spudDO.setId(spuId);
        spuAttributeDO.setId(spuAttributeId);
        spuAttributeValueDO.setSpu(spudDO);
        spuAttributeValueDO.setSpuAttribute(spuAttributeDO);
        spuAttributeValueDO.setName(name);
        return spuAttributeValueDO;
    }

    public List<SpuAttributeValueDO> toSpuAttributeValueDOList(Long spuId, List<SpuAttributeDTO> spuAttributeDTOList) {
        return spuAttributeDTOList.stream()
                .flatMap(spuAttributeDTO -> spuAttributeDTO.getSpuAttributeValueDTOList()
                        .stream()
                        .map(spuAttributeValueDTO -> toSpuAttributeValueDO(spuId, spuAttributeDTO.getId(), spuAttributeValueDTO.getName())))
                .collect(Collectors.toList());

    }

}
