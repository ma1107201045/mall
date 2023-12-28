package com.lingyi.mall.biz.product.dao.mapper;

import com.lingyi.mall.biz.product.model.query.SkuQuery;
import com.lingyi.mall.biz.product.model.vo.SkuVO;
import com.lingyi.mall.common.orm.mybatis.MybatisMapperImplementation;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author: maweiyan
 * @Email: 1107201045@qq.com
 * @DateTime: 2023/8/31 9:24
 * @Description:
 */
@Mapper
public interface SkuMapper extends MybatisMapperImplementation<SkuVO, SkuQuery, Long> {
}
