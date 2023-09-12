package com.lingyi.mall.biz.product.mapper;

import com.lingyi.mall.biz.product.param.SkuParam;
import com.lingyi.mall.biz.product.vo.SkuVO;
import com.lingyi.mall.common.orm.mybatis.MybatisMapperImplementation;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author: maweiyan
 * @Email: 1107201045@qq.com
 * @DateTime: 2023/8/31 9:24
 * @Description:
 */
@Mapper
public interface SkuMapper extends MybatisMapperImplementation<SkuVO, SkuParam, Long> {
}
