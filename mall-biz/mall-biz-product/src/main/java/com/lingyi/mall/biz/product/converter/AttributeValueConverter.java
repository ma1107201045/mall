package com.lingyi.mall.biz.product.converter;

import com.lingyi.mall.biz.product.model.entity.AttributeDO;
import com.lingyi.mall.biz.product.model.entity.AttributeValueDO;

import java.util.List;

/**
 * @Author: maweiyan
 * @Email: 1107201045@qq.com
 * @DateTime: 2023/9/5 10:55
 * @Description:
 */
public final class AttributeValueConverter {

    public static final AttributeValueConverter INSTANCE = new AttributeValueConverter();

    private AttributeValueConverter() {

    }

    public AttributeValueDO of(Long attributeId, String name) {
        var attributeDO = new AttributeDO();
        attributeDO.setId(attributeId);
        var attributeValueDO = new AttributeValueDO();
        attributeValueDO.setAttribute(attributeDO);
        attributeValueDO.setName(name);
        return attributeValueDO;
    }

    public List<AttributeValueDO> of(Long attributeId, List<String> names) {
        return names.stream()
                .map(name -> of(attributeId, name))
                .toList();
    }

}
