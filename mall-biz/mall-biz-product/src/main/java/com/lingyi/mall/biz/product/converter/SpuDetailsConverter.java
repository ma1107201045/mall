package com.lingyi.mall.biz.product.converter;

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

    public SpuDetailsDO toSpuDetailsDO(String content) {
        var spuDetailsDO = new SpuDetailsDO();
        spuDetailsDO.setContent(content);
        return spuDetailsDO;
    }
}
