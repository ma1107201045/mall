package com.lingyi.mall.biz.product.service.impl;

import com.lingyi.mall.biz.product.converter.CategoryAttributeConverter;
import com.lingyi.mall.biz.product.model.dto.CategoryAttributeDTO;
import com.lingyi.mall.biz.product.model.entity.CategoryAttributeDO;
import com.lingyi.mall.biz.product.dao.mapper.CategoryAttributeMapper;
import com.lingyi.mall.biz.product.model.query.CategoryAttributeQuery;
import com.lingyi.mall.biz.product.dao.repository.CategoryAttributeRepository;
import com.lingyi.mall.biz.product.service.CategoryAttributeService;
import com.lingyi.mall.biz.product.model.vo.CategoryAttributeVO;
import com.lingyi.mall.common.orm.util.BaseServiceProImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: maweiyan
 * @Email: 1107201045@qq.com
 * @DateTime: 2023/8/31 9:52
 * @Description:
 */
@Service
public class CategoryAttributeServiceImpl extends BaseServiceProImpl<CategoryAttributeRepository, CategoryAttributeMapper, CategoryAttributeDTO, CategoryAttributeVO, CategoryAttributeQuery, CategoryAttributeDO, Long>
        implements CategoryAttributeService {

    @Override
    public void createList(Long categoryId, List<Long> attributeIds) {
        var categoryAttributes = CategoryAttributeConverter.INSTANCE.of(categoryId, attributeIds);
        jpaRepository.saveAll(categoryAttributes);
    }

    @Override
    public void deleteByCategoryIds(List<Long> categoryIds) {
        jpaRepository.deleteByCategoryIds(categoryIds);
    }
}
