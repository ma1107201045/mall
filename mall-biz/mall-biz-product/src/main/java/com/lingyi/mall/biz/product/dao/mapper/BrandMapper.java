package com.lingyi.mall.biz.product.dao.mapper;

import com.lingyi.mall.biz.product.model.param.BrandParam;
import com.lingyi.mall.biz.product.model.vo.BrandVO;
import com.lingyi.mall.common.orm.mybatis.MybatisMapperImplementation;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author: maweiyan
 * @Email: 1107201045@qq.com
 * @DateTime: 2023/8/31 9:21
 * @Description:
 */
@Mapper
public interface BrandMapper extends MybatisMapperImplementation<BrandVO, BrandParam, Long> {

}
