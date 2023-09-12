package com.lingyi.mall.biz.product.mapper;

import com.lingyi.mall.biz.product.param.SpuParam;
import com.lingyi.mall.biz.product.vo.SpuVO;
import com.lingyi.mall.common.orm.mybatis.MybatisMapperImplementation;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/6/10 11:14
 * @description
 */
@Mapper
public interface SpuMapper extends MybatisMapperImplementation<SpuVO, SpuParam, Long> {
}
