package com.lingyi.mall.biz.product.converter;

import com.lingyi.mall.biz.product.model.entity.AttributeDO;
import com.lingyi.mall.biz.product.model.entity.CategoryAttributeDO;
import com.lingyi.mall.biz.product.model.entity.CategoryDO;

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


    public CategoryAttributeDO toCategoryAttributeDO(Long categoryId, Long attributeId) {
        var categoryDO = new CategoryDO();
        var attributeDO = new AttributeDO();
        var categoryAttributeDO = new CategoryAttributeDO();
        categoryDO.setId(categoryId);
        attributeDO.setId(attributeId);
        categoryAttributeDO.setCategory(categoryDO);
        categoryAttributeDO.setAttribute(attributeDO);
        return categoryAttributeDO;
    }

    public List<CategoryAttributeDO> toCategoryAttributeDOList(Long categoryId, List<Long> attributeIds) {
        return attributeIds.stream()
                .map(attributeId -> toCategoryAttributeDO(categoryId, attributeId))
                .toList();
    }
}
