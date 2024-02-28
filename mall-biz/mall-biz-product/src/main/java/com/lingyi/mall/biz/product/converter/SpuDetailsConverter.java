package com.lingyi.mall.biz.product.converter;

import com.lingyi.mall.biz.product.model.dto.SpuDetailsDTO;
import com.lingyi.mall.biz.product.model.entity.SpuDO;
import com.lingyi.mall.biz.product.model.entity.SpuDetailsDO;

/**
 * @Author: maweiyan
 * @Email: 1107201045@qq.com
 * @DateTime: 2024/2/28 9:11
 * @Description:
 */
public final class SpuDetailsConverter {

    public static final SpuDetailsConverter INSTANCE = new SpuDetailsConverter();

    private SpuDetailsConverter() {

    }

    public SpuDetailsDO toSpuDetailsDO(SpuDetailsDTO spuDetailsDTO) {
        var spudDO = new SpuDO();
        var spuDetailsDO = new SpuDetailsDO();
        spudDO.setId(spuDetailsDTO.getSpuId());
        spuDetailsDO.setId(spuDetailsDTO.getId());
        spuDetailsDO.setSpuDO(spudDO);
        spuDetailsDO.setContent(spuDetailsDTO.getContent());
        return spuDetailsDO;
    }
}
