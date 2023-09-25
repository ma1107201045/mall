package com.lingyi.mall.biz.product.service;

import com.lingyi.mall.biz.product.dto.CategoryDTO;
import com.lingyi.mall.biz.product.entity.CategoryDO;
import com.lingyi.mall.biz.product.param.CategoryParam;
import com.lingyi.mall.biz.product.vo.AttributeVO;
import com.lingyi.mall.biz.product.vo.CategoryVO;
import com.lingyi.mall.common.orm.util.BaseServicePro;

import java.util.List;

/**
 * @Author: maweiyan
 * @Email: 1107201045@qq.com
 * @DateTime: 2023/8/31 9:51
 * @Description:
 */
public interface CategoryService extends BaseServicePro<CategoryDTO, CategoryVO, CategoryParam, CategoryDO, Long> {


    /**
     * @param categoryDTO 。。
     */
    void create(CategoryDTO categoryDTO);

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
