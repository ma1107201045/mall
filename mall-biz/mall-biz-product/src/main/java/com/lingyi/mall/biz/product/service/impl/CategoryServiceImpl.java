package com.lingyi.mall.biz.product.service.impl;

import com.lingyi.mall.biz.product.dto.CategoryDTO;
import com.lingyi.mall.biz.product.entity.CategoryDO;
import com.lingyi.mall.biz.product.mapper.CategoryMapper;
import com.lingyi.mall.biz.product.param.CategoryParam;
import com.lingyi.mall.biz.product.repository.CategoryRepository;
import com.lingyi.mall.biz.product.service.CategoryService;
import com.lingyi.mall.biz.product.vo.CategoryVO;
import com.lingyi.mall.common.orm.util.BaseServiceProImpl;
import org.springframework.stereotype.Service;

/**
 * @Author: maweiyan
 * @Email: 1107201045@qq.com
 * @DateTime: 2023/8/31 9:51
 * @Description:
 */
@Service
public class CategoryServiceImpl extends BaseServiceProImpl<CategoryRepository, CategoryMapper, CategoryDTO, CategoryVO, CategoryParam, CategoryDO, Long> implements CategoryService {

}
