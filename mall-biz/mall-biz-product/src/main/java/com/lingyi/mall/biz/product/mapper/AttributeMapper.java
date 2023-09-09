package com.lingyi.mall.biz.product.mapper;

import com.lingyi.mall.biz.product.param.AttributeParam;
import com.lingyi.mall.biz.product.vo.AttributeVO;
import com.lingyi.mall.common.orm.util.MybatisMapperImplementation;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author: maweiyan
 * @Email: 1107201045@qq.com
 * @DateTime: 2023/8/31 9:23
 * @Description:
 */
@Mapper
public interface AttributeMapper extends MybatisMapperImplementation<Long, AttributeParam, AttributeVO> {

}
