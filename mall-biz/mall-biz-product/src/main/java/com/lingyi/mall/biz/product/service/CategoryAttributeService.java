package com.lingyi.mall.biz.product.service;

import com.lingyi.mall.biz.product.model.dto.CategoryAttributeDTO;
import com.lingyi.mall.biz.product.model.entity.CategoryAttributeDO;
import com.lingyi.mall.biz.product.model.query.CategoryAttributeQuery;
import com.lingyi.mall.biz.product.model.vo.CategoryAttributeVO;
import com.lingyi.mall.common.orm.util.BaseServicePro;

import java.util.List;

/**
 * @Author: maweiyan
 * @Email: 1107201045@qq.com
 * @DateTime: 2023/8/31 9:52
 * @Description:
 */
public interface CategoryAttributeService extends BaseServicePro<CategoryAttributeDTO, CategoryAttributeVO, CategoryAttributeQuery, CategoryAttributeDO, Long> {


    /**
     * 批量创建属性值
     *
     * @param categoryId   分类id
     * @param attributeIds 属性id集
     */
    void createList(Long categoryId, List<Long> attributeIds);

    /**
     * 通过屬性名id删除
     *
     * @param attributeIds 屬性名id集合
     */
    void deleteByCategoryIds(List<Long> attributeIds);
}
