package com.lingyi.mall.biz.product.converter;

import com.lingyi.mall.biz.product.entity.AttributeDO;
import com.lingyi.mall.biz.product.entity.AttributeValueDO;

/**
 * @Author: maweiyan
 * @Email: 1107201045@qq.com
 * @DateTime: 2023/9/5 10:55
 * @Description:
 */
public class AttributeValueConverter {

    public static final AttributeValueConverter INSTANCE = new AttributeValueConverter();

    private AttributeValueConverter() {

    }

    public AttributeValueDO of(Long attributeId, String attributeValueName) {
        var attributeValueDO = new AttributeValueDO();
        var attributeDO = new AttributeDO();
        attributeDO.setId(attributeId);
        attributeValueDO.setAttributeDO(attributeDO);
        attributeValueDO.setName(attributeValueName);
        return attributeValueDO;
    }
}
