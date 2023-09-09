package com.lingyi.mall.biz.product.mapper;

import com.lingyi.mall.biz.product.param.CategoryParam;
import com.lingyi.mall.biz.product.vo.CategoryVO;
import com.lingyi.mall.common.jdbc.util.MybatisMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/6/10 11:15
 * @description
 */
@Mapper
public interface CategoryMapper extends MybatisMapper<Long, CategoryParam, CategoryVO> {
}
