package com.lingyi.mall.biz.product.service.impl;

import com.lingyi.mall.biz.product.dto.AttributeDTO;
import com.lingyi.mall.biz.product.dto.CategoryDTO;
import com.lingyi.mall.biz.product.entity.CategoryDO;
import com.lingyi.mall.biz.product.mapper.CategoryMapper;
import com.lingyi.mall.biz.product.param.AttributeParam;
import com.lingyi.mall.biz.product.param.CategoryParam;
import com.lingyi.mall.biz.product.repository.CategoryRepository;
import com.lingyi.mall.biz.product.service.AttributeService;
import com.lingyi.mall.biz.product.service.CategoryAttributeService;
import com.lingyi.mall.biz.product.service.CategoryService;
import com.lingyi.mall.biz.product.vo.AttributeVO;
import com.lingyi.mall.biz.product.vo.CategoryVO;
import com.lingyi.mall.common.core.constant.BaseConstant;
import com.lingyi.mall.common.core.util.ObjectUtil;
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

    private final AttributeService attributeService;

    private final CategoryAttributeService categoryAttributeService;


    @Override
    public void create(CategoryDTO categoryDTO) {
        var id = create(categoryDTO, CategoryDO.class);
        categoryAttributeService.createList(id, categoryDTO.getAttributeIds());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteByIds(List<Long> ids) {
        super.deleteByIds(ids);
        //批量删除属性值信息
        categoryAttributeService.deleteByCategoryIds(ids);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateById(CategoryDTO categoryDTO) {
        var id = categoryDTO.getId();
        super.updateById(categoryDTO);
        //批量删除分类属性信息
        categoryAttributeService.deleteByCategoryIds(Collections.singletonList(id));
        //批量保存分类属性信息
        categoryAttributeService.createList(id, categoryDTO.getAttributeIds());
    }

    @Override
    public List<CategoryVO> readTree() {
        var categoryParam = new CategoryParam();
        categoryParam.setSortField("sort");
        categoryParam.setSortDirection("ASC");
        var categories = readListByParam(categoryParam);
        return toTree(BaseConstant.TREE_ROOT_ID, categories);
    }

    @Override
    public List<AttributeVO> readAttributeList() {
        return attributeService.readListByParam(ObjectUtil.newInstance(AttributeParam.class));
    }


    private List<CategoryVO> toTree(Long parentId, List<CategoryVO> categories) {
        return categories.stream()
                .filter(category -> category.getParentId().equals(parentId))
                .peek(category -> category.setChildren(toTree(category.getId(), categories)))
                .collect(Collectors.toList());
    }
}
