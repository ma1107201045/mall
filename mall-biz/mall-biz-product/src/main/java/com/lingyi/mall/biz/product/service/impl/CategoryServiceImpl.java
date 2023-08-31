package com.lingyi.mall.biz.product.service.impl;

import com.lingyi.mall.biz.product.entity.CategoryDO;
import com.lingyi.mall.biz.product.mapper.CategoryMapper;
import com.lingyi.mall.biz.product.repository.CategoryAttributeRepository;
import com.lingyi.mall.biz.product.repository.CategoryRepository;
import com.lingyi.mall.biz.product.service.CategoryService;
import com.lingyi.mall.common.base.param.BasePageParam;
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

    }

    @Override
    public void deleteByIds(List<Long> longs) {

    }

    @Override
    public void updateById(CategoryDO categoryDO) {

    }

    @Override
    public CategoryDO readById(Long aLong) {
        return null;
    }

    @Override
    public List<CategoryDO> readListByParam(BasePageParam param) {
        return null;
    }
}
