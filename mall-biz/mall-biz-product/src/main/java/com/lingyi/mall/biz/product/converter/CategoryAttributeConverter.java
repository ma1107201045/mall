package com.lingyi.mall.biz.product.converter;

import com.lingyi.mall.biz.product.entity.AttributeDO;
import com.lingyi.mall.biz.product.entity.CategoryAttributeDO;
import com.lingyi.mall.biz.product.entity.CategoryDO;

import java.util.List;

/**
 * @Author: maweiyan
 * @Email: 1107201045@qq.com
 * @DateTime: 2023/9/26 14:34
 * @Description:
 */
public final class CategoryAttributeConverter {
    public static final CategoryAttributeConverter INSTANCE = new CategoryAttributeConverter();

    private CategoryAttributeConverter() {

    }


    public CategoryAttributeDO of(Long categoryId, Long attributeId) {
        CategoryDO categoryDO = new CategoryDO();
        categoryDO.setId(categoryId);

        AttributeDO attributeDO = new AttributeDO();
        attributeDO.setId(attributeId);

        CategoryAttributeDO categoryAttributeDO = new CategoryAttributeDO();
        categoryAttributeDO.setCategoryDO(categoryDO);
        categoryAttributeDO.setAttributeDO(attributeDO);
        return categoryAttributeDO;
    }

    public List<CategoryAttributeDO> of(Long categoryId, List<Long> attributeIds) {
        return attributeIds.stream()
                .map(attributeId -> of(categoryId, attributeId))
                .toList();
    }
}
