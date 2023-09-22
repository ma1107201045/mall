package com.lingyi.mall.biz.product.service.impl;

import com.lingyi.mall.biz.product.dto.AttributeDTO;
import com.lingyi.mall.biz.product.dto.CategoryDTO;
import com.lingyi.mall.biz.product.entity.CategoryDO;
import com.lingyi.mall.biz.product.mapper.CategoryMapper;
import com.lingyi.mall.biz.product.param.CategoryParam;
import com.lingyi.mall.biz.product.repository.CategoryRepository;
import com.lingyi.mall.biz.product.service.AttributeService;
import com.lingyi.mall.biz.product.service.CategoryAttributeService;
import com.lingyi.mall.biz.product.service.CategoryService;
import com.lingyi.mall.biz.product.vo.CategoryVO;
import com.lingyi.mall.common.core.constant.BaseConstant;
import com.lingyi.mall.common.orm.util.BaseServiceProImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author: maweiyan
 * @Email: 1107201045@qq.com
 * @DateTime: 2023/8/31 9:51
 * @Description:
 */
@Service
@RequiredArgsConstructor
public class CategoryServiceImpl extends BaseServiceProImpl<CategoryRepository, CategoryMapper, CategoryDTO, CategoryVO, CategoryParam, CategoryDO, Long> implements CategoryService {

    private final CategoryAttributeService categoryAttributeService;

    private final AttributeService attributeService;

    @Override
    public void create(CategoryDTO categoryDTO) {
        create(categoryDTO, CategoryDO.class);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateById(CategoryDTO categoryDTO) {
        super.updateById(categoryDTO);
    }

    @Override
    public List<CategoryVO> readTree() {
        var categoryParam = new CategoryParam();
        categoryParam.setSortField("sort");
        categoryParam.setSortDirection("ASC");
        var categories = readListByParam(categoryParam);
        return toTree(BaseConstant.TREE_ROOT_ID, categories);
    }


    private List<CategoryVO> toTree(Long parentId, List<CategoryVO> categories) {
        return categories.stream()
                .filter(category -> category.getParentId().equals(parentId))
                .peek(category -> category.setChildren(toTree(category.getId(), categories)))
                .collect(Collectors.toList());
    }
}
