package com.lingyi.mall.biz.product.service.impl;

import com.lingyi.mall.biz.product.entity.CategoryAttributeDO;
import com.lingyi.mall.biz.product.mapper.CategoryAttributeMapper;
import com.lingyi.mall.biz.product.repository.CategoryAttributeRepository;
import com.lingyi.mall.biz.product.service.CategoryAttributeService;
import com.lingyi.mall.common.orm.param.BasePageParam;
import com.lingyi.mall.common.core.util.ConverterUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: maweiyan
 * @Email: 1107201045@qq.com
 * @DateTime: 2023/8/31 9:52
 * @Description:
 */
@Service
@RequiredArgsConstructor
public class CategoryAttributeServiceImpl implements CategoryAttributeService {

    private final CategoryAttributeRepository categoryAttributeRepository;

    private final CategoryAttributeMapper categoryAttributeMapper;

    @Override
    public void create(CategoryAttributeDO categoryAttributeDO) {
        categoryAttributeRepository.save(categoryAttributeDO);
    }

    @Override
    public void deleteByIds(List<Long> ids) {
        categoryAttributeRepository.deleteAllById(ids);
    }

    @Override
    public void updateById(CategoryAttributeDO categoryAttributeDO) {
        var optional = categoryAttributeRepository.findById(categoryAttributeDO.getId());
        if (optional.isEmpty()) {
            return;
        }
        var newCategoryAttributeDO = optional.get();
        ConverterUtil.to(categoryAttributeDO, newCategoryAttributeDO);
        categoryAttributeRepository.save(newCategoryAttributeDO);
    }

    @Override
    public CategoryAttributeDO readById(Long id) {
        return null;
    }

    @Override
    public List<CategoryAttributeDO> readListByParam(BasePageParam param) {
        return null;
    }
}
