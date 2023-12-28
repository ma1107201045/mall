package com.lingyi.mall.biz.product.dao.mapper;

import com.lingyi.mall.biz.product.model.query.SpuLikeQuery;
import com.lingyi.mall.biz.product.model.vo.SpuLikeVO;
import com.lingyi.mall.common.orm.mybatis.MybatisMapperImplementation;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author: maweiyan
 * @Email: 1107201045@qq.com
 * @DateTime: 2023/11/28 14:20
 * @Description:
 */
@Mapper
public interface SpuLikeMapper extends MybatisMapperImplementation<SpuLikeVO, SpuLikeQuery, Long> {
}
