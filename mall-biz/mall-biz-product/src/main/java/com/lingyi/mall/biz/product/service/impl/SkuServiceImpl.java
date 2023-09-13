package com.lingyi.mall.biz.product.service.impl;

import com.lingyi.mall.biz.product.dto.SkuDTO;
import com.lingyi.mall.biz.product.entity.SkuDO;
import com.lingyi.mall.biz.product.mapper.SkuMapper;
import com.lingyi.mall.biz.product.param.SkuParam;
import com.lingyi.mall.biz.product.repository.SkuRepository;
import com.lingyi.mall.biz.product.service.SkuService;
import com.lingyi.mall.biz.product.vo.SkuVO;
import com.lingyi.mall.common.orm.util.BaseServiceProImpl;
import org.springframework.stereotype.Service;

/**
 * @Author: maweiyan
 * @Email: 1107201045@qq.com
 * @DateTime: 2023/8/31 9:33
 * @Description:
 */
@Service
public class SkuServiceImpl extends BaseServiceProImpl<SkuRepository, SkuMapper, SkuDTO, SkuVO, SkuParam, SkuDO, Long> implements SkuService {


}
