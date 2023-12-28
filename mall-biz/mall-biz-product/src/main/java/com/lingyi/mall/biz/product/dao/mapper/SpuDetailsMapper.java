package com.lingyi.mall.biz.product.dao.mapper;

import com.lingyi.mall.biz.product.model.query.SpuDetailsQuery;
import com.lingyi.mall.biz.product.model.vo.SpuDetailsVO;
import com.lingyi.mall.common.orm.mybatis.MybatisMapperImplementation;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author: maweiyan
 * @Email: 1107201045@qq.com
 * @DateTime: 2023/11/28 14:21
 * @Description:
 */
@Mapper
public interface SpuDetailsMapper extends MybatisMapperImplementation<SpuDetailsVO, SpuDetailsQuery, Long> {
}
