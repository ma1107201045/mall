package com.lingyi.mall.biz.product.converter;

import com.lingyi.mall.biz.product.model.dto.SpuAttributeDTO;
import com.lingyi.mall.biz.product.model.entity.AttributeDO;
import com.lingyi.mall.biz.product.model.entity.AttributeValueDO;
import com.lingyi.mall.biz.product.model.entity.SpuAttributeDO;
import com.lingyi.mall.biz.product.model.entity.SpuAttributeValueDO;

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

    public SpuAttributeValueDO toSpuAttributeValueDO(Long spuAttributeId, String name) {
        var spuAttributeDO = new SpuAttributeDO();
        var spuAttributeValueDO = new SpuAttributeValueDO();
        spuAttributeDO.setId(spuAttributeId);
        spuAttributeValueDO.setSpuAttribute(spuAttributeDO);
        spuAttributeValueDO.setName(name);
        return spuAttributeValueDO;
    }

    public List<SpuAttributeValueDO> toSpuAttributeValueDOList(List<SpuAttributeDTO> spuAttributeDTOList) {
        return spuAttributeDTOList.stream()
                .flatMap(spuAttributeDTO -> spuAttributeDTO.getSpuAttributeValueDTOList()
                        .stream()
                        .map(spuAttributeValueDTO -> toSpuAttributeValueDO(spuAttributeDTO.getId(), spuAttributeValueDTO.getName())))
                .collect(Collectors.toList());

    }

}
