package com.lingyi.mall.biz.product.service;

import com.lingyi.mall.biz.product.model.dto.SpuCollectDTO;
import com.lingyi.mall.biz.product.model.dto.SpuDetailsDTO;
import com.lingyi.mall.biz.product.model.entity.SpuCollectDO;
import com.lingyi.mall.biz.product.model.entity.SpuDetailsDO;
import com.lingyi.mall.biz.product.model.param.SpuCollectParam;
import com.lingyi.mall.biz.product.model.param.SpuDetailsParam;
import com.lingyi.mall.biz.product.model.vo.SpuCollectVO;
import com.lingyi.mall.biz.product.model.vo.SpuDetailsVO;
import com.lingyi.mall.common.orm.util.BaseServicePro;

/**
 * @Author: maweiyan
 * @Email: 1107201045@qq.com
 * @DateTime: 2023/12/1 14:08
 * @Description:
 */
public interface SpuCollectService extends BaseServicePro<SpuCollectDTO, SpuCollectVO, SpuCollectParam,
        SpuCollectDO, Long> {
}

