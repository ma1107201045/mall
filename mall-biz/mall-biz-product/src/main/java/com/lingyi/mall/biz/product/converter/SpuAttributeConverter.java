package com.lingyi.mall.biz.product.converter;

import com.lingyi.mall.biz.product.model.dto.SpuAttributeDTO;
import com.lingyi.mall.biz.product.model.entity.SpuAttributeDO;
import com.lingyi.mall.biz.product.model.entity.SpuAttributeValueDO;
import com.lingyi.mall.biz.product.model.entity.SpuDO;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author: maweiyan
 * @Email: 1107201045@qq.com
 * @DateTime: 2024/2/27 16:09
 * @Description:
 */
public final class SpuAttributeConverter {

    public static final SpuAttributeConverter INSTANCE = new SpuAttributeConverter();

    private SpuAttributeConverter() {

    }

    public SpuAttributeDO toSpuAttributeDO(Long spuId, String name) {
        var spuDO = new SpuDO();
        spuDO.setId(spuId);
        var spuAttributeDO = new SpuAttributeDO();
        spuAttributeDO.setSpuDO(spuDO);
        spuAttributeDO.setName(name);
        return spuAttributeDO;
    }

    public List<SpuAttributeDO> toSpuAttributeDOList(Long spuId, List<SpuAttributeDTO> spuAttributeDTOList) {
        return spuAttributeDTOList.stream()
                .map(spuAttributeDTO -> toSpuAttributeDO(spuId, spuAttributeDTO.getName()))
                .collect(Collectors.toList());

    }
}
