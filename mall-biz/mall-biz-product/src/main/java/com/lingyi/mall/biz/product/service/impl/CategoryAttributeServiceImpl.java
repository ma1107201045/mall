package com.lingyi.mall.biz.product.service.impl;

import com.lingyi.mall.biz.product.entity.CategoryAttributeDO;
import com.lingyi.mall.biz.product.mapper.CategoryAttributeMapper;
import com.lingyi.mall.biz.product.repository.CategoryAttributeRepository;
import com.lingyi.mall.biz.product.service.CategoryAttributeService;
import com.lingyi.mall.common.base.param.BasePageParam;
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

    }

    @Override
    public void deleteByIds(List<Long> longs) {

    }

    @Override
    public void updateById(CategoryAttributeDO categoryAttributeDO) {

    }

    @Override
    public CategoryAttributeDO readById(Long aLong) {
        return null;
    }

    @Override
    public List<CategoryAttributeDO> readListByParam(BasePageParam param) {
        return null;
    }
}
