package com.lingyi.mall.biz.product.dao.mapper;

import com.lingyi.mall.biz.product.model.query.SkuEvaluateReplyQuery;
import com.lingyi.mall.biz.product.model.vo.SkuEvaluateReplyVO;
import com.lingyi.mall.common.orm.mybatis.MybatisMapperImplementation;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author: maweiyan
 * @Email: 1107201045@qq.com
 * @DateTime: 2023/11/28 14:25
 * @Description:
 */
@Mapper
public interface SkuEvaluateReplyMapper extends MybatisMapperImplementation<SkuEvaluateReplyVO, SkuEvaluateReplyQuery, Long> {
}
