package com.lingyi.mall.biz.product.mapper;

import com.lingyi.mall.biz.product.param.AttributeValueParam;
import com.lingyi.mall.biz.product.vo.AttributeValueVO;
import com.lingyi.mall.common.jdbc.util.MybatisMapperImplementation;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author: maweiyan
 * @Email: 1107201045@qq.com
 * @DateTime: 2023/8/31 9:25
 * @Description:
 */
@Mapper
public interface AttributeValueMapper extends MybatisMapperImplementation<Long, AttributeValueParam, AttributeValueVO> {
}
