package com.lingyi.mall.biz.product.service.impl;

import com.lingyi.mall.biz.product.model.dto.BrandDTO;
import com.lingyi.mall.biz.product.model.entity.BrandDO;
import com.lingyi.mall.biz.product.dao.mapper.BrandMapper;
import com.lingyi.mall.biz.product.model.param.BrandParam;
import com.lingyi.mall.biz.product.dao.repository.BrandRepository;
import com.lingyi.mall.biz.product.service.BrandService;
import com.lingyi.mall.biz.product.model.vo.BrandVO;
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
