package com.lingyi.mall.biz.product.service.impl;

import com.lingyi.mall.biz.product.entity.CategoryDO;
import com.lingyi.mall.biz.product.mapper.CategoryMapper;
import com.lingyi.mall.biz.product.repository.CategoryRepository;
import com.lingyi.mall.biz.product.service.CategoryService;
import com.lingyi.mall.common.jdbc.param.BasePageParam;
import com.lingyi.mall.common.core.util.ConverterUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: maweiyan
 * @Email: 1107201045@qq.com
 * @DateTime: 2023/8/31 9:51
 * @Description:
 */
@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    private final CategoryMapper categoryMapper;

    @Override
    public void create(CategoryDO categoryDO) {
        categoryRepository.save(categoryDO);
    }

    @Override
    public void deleteByIds(List<Long> ids) {
        categoryRepository.deleteAllById(ids);
    }

    @Override
    public void updateById(CategoryDO categoryDO) {
        var optional = categoryRepository.findById(categoryDO.getId());
        if (optional.isEmpty()) {
            return;
        }
        var newCategoryDO = optional.get();
        ConverterUtil.to(categoryDO, newCategoryDO);
        categoryRepository.save(newCategoryDO);
    }

    @Override
    public CategoryDO readById(Long id) {
        return null;
    }

    @Override
    public List<CategoryDO> readListByParam(BasePageParam param) {
        return null;
    }
}
