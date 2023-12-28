package com.lingyi.mall.biz.product.dao.mapper;

import com.lingyi.mall.biz.product.model.query.SpuCollectQuery;
import com.lingyi.mall.biz.product.model.vo.SpuCollectVO;
import com.lingyi.mall.common.orm.mybatis.MybatisMapperImplementation;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author: maweiyan
 * @Email: 1107201045@qq.com
 * @DateTime: 2023/11/28 14:21
 * @Description:
 */
@Mapper
public interface SpuCollectMapper extends MybatisMapperImplementation<SpuCollectVO, SpuCollectQuery, Long> {
}
