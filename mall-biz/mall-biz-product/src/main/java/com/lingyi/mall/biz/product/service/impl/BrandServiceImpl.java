package com.lingyi.mall.biz.product.service.impl;

import com.lingyi.mall.biz.product.dto.BrandDTO;
import com.lingyi.mall.biz.product.entity.BrandDO;
import com.lingyi.mall.biz.product.mapper.BrandMapper;
import com.lingyi.mall.biz.product.param.BrandParam;
import com.lingyi.mall.biz.product.repository.BrandRepository;
import com.lingyi.mall.biz.product.service.BrandService;
import com.lingyi.mall.biz.product.vo.BrandVO;
import com.lingyi.mall.common.orm.util.BaseServiceProImpl;
import org.springframework.stereotype.Service;

/**
 * @Author: maweiyan
 * @Email: 1107201045@qq.com
 * @DateTime: 2023/8/31 9:42
 * @Description:
 */
@Service
public class BrandServiceImpl extends BaseServiceProImpl<BrandRepository, BrandMapper, BrandDTO, BrandVO, BrandParam, BrandDO, Long> implements BrandService {


}
