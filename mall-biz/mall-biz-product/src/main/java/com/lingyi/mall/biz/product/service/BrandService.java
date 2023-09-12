package com.lingyi.mall.biz.product.service;

import com.lingyi.mall.biz.product.dto.BrandDTO;
import com.lingyi.mall.biz.product.entity.BrandDO;
import com.lingyi.mall.biz.product.param.BrandParam;
import com.lingyi.mall.biz.product.vo.BrandVO;
import com.lingyi.mall.common.orm.param.BasePageParam;
import com.lingyi.mall.common.orm.util.BaseService;
import com.lingyi.mall.common.orm.util.BaseServicePro;

/**
 * @Author: maweiyan
 * @Email: 1107201045@qq.com
 * @DateTime: 2023/8/31 9:41
 * @Description:
 */
public interface BrandService extends BaseServicePro<BrandDTO, BrandVO, BrandParam, BrandDO, Long> {
}
