package com.lingyi.mall.biz.product.mapper;

import com.lingyi.mall.biz.product.param.BrandParam;
import com.lingyi.mall.biz.product.vo.BrandVO;
import com.lingyi.mall.common.jdbc.util.MybatisMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author: maweiyan
 * @Email: 1107201045@qq.com
 * @DateTime: 2023/8/31 9:21
 * @Description:
 */
@Mapper
public interface BrandMapper extends MybatisMapper<Long, BrandParam, BrandVO> {

}
