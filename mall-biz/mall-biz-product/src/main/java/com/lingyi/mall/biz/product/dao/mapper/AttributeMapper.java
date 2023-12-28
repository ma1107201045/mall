package com.lingyi.mall.biz.product.dao.mapper;

import com.lingyi.mall.biz.product.model.query.AttributeQuery;
import com.lingyi.mall.biz.product.model.vo.AttributeVO;
import com.lingyi.mall.common.orm.mybatis.MybatisMapperImplementation;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author: maweiyan
 * @Email: 1107201045@qq.com
 * @DateTime: 2023/8/31 9:23
 * @Description:
 */
@Mapper
public interface AttributeMapper extends MybatisMapperImplementation<AttributeVO, AttributeQuery, Long> {

}
