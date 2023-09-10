package com.lingyi.mall.biz.product.mapper;

import com.lingyi.mall.biz.product.param.CategoryAttributeParam;
import com.lingyi.mall.biz.product.vo.CategoryAttributeVO;
import com.lingyi.mall.common.orm.mybatis.MybatisMapperImplementation;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author: maweiyan
 * @Email: 1107201045@qq.com
 * @DateTime: 2023/8/31 9:25
 * @Description:
 */
@Mapper
public interface CategoryAttributeMapper extends MybatisMapperImplementation<Long, CategoryAttributeParam, CategoryAttributeVO> {
}
