package com.lingyi.mall.biz.product.dao.mapper;

import com.lingyi.mall.biz.product.model.param.SkuEvaluateParam;
import com.lingyi.mall.biz.product.model.vo.SkuEvaluateVO;
import com.lingyi.mall.common.orm.mybatis.MybatisMapperImplementation;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author: maweiyan
 * @Email: 1107201045@qq.com
 * @DateTime: 2023/11/28 14:22
 * @Description:
 */
@Mapper
public interface SkuEvaluateMapper extends MybatisMapperImplementation<SkuEvaluateVO, SkuEvaluateParam, Long> {
}
