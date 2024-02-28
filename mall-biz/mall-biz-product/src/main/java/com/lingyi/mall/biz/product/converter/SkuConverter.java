package com.lingyi.mall.biz.product.converter;

import com.lingyi.mall.biz.product.model.dto.SkuDTO;
import com.lingyi.mall.biz.product.model.entity.SkuDO;
import com.lingyi.mall.biz.product.model.entity.SpuAttributeValueDO;
import com.lingyi.mall.biz.product.model.entity.SpuDO;
import com.lingyi.mall.common.core.util.ConverterUtil;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author: maweiyan
 * @Email: 1107201045@qq.com
 * @DateTime: 2024/2/28 14:46
 * @Description:
 */
public final class SkuConverter {

    public static final SkuConverter INSTANCE = new SkuConverter();

    private SkuConverter() {

    }

    public SkuDO toSkuDO(Long spuId, SkuDTO skuDTO) {
        var skuDO = ConverterUtil.to(skuDTO, SkuDO.class);
        SpuDO spuDO = new SpuDO();
        spuDO.setId(spuId);
        skuDO.setSpuDO(spuDO);
        skuDO.setSpuDO(spuDO);
        return skuDO;
    }

    public List<SkuDO> toSkuDOList(Long spuId, List<SkuDTO> skuDTOList) {
        return skuDTOList.stream()
                .map(skuDTO -> toSkuDO(spuId, skuDTO))
                .collect(Collectors.toList());
    }
}
