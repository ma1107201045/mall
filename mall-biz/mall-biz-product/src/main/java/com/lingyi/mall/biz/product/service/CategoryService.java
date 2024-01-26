package com.lingyi.mall.biz.product.service;

import com.lingyi.mall.biz.product.model.dto.CategoryDTO;
import com.lingyi.mall.biz.product.model.entity.CategoryDO;
import com.lingyi.mall.biz.product.model.query.CategoryQuery;
import com.lingyi.mall.biz.product.model.vo.AttributeVO;
import com.lingyi.mall.biz.product.model.vo.CategoryVO;
import com.lingyi.mall.common.orm.util.BaseServicePro;

import java.util.List;

/**
 * @Author: maweiyan
 * @Email: 1107201045@qq.com
 * @DateTime: 2023/8/31 9:51
 * @Description:
 */
public interface CategoryService extends BaseServicePro<CategoryDTO, CategoryVO, CategoryQuery, CategoryDO, Long> {


    /**
     * @param categoryDTO 。。
     */
    void create(CategoryDTO categoryDTO);

    /**
     * @param categoryDTO ..
     */
    void updateByDTO(CategoryDTO categoryDTO);

    /**
     * 通过父级id查询分类树
     *
     * @return List<MenuVO>
     */
    List<CategoryVO> readTree();


    /**
     * 读取属性集合
     *
     * @return List<AttributeVO>
     */
    List<AttributeVO> readAttributeList();
}
