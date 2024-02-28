package com.lingyi.mall.biz.product.service;

import com.lingyi.mall.biz.product.model.dto.SpuDetailsDTO;
import com.lingyi.mall.biz.product.model.entity.SpuDetailsDO;
import com.lingyi.mall.biz.product.model.query.SpuDetailsQuery;
import com.lingyi.mall.biz.product.model.vo.SpuDetailsVO;
import com.lingyi.mall.common.orm.util.BaseServicePro;

/**
 * @Author: maweiyan
 * @Email: 1107201045@qq.com
 * @DateTime: 2023/12/1 14:08
 * @Description:
 */
public interface SpuDetailsService extends BaseServicePro<SpuDetailsDTO, SpuDetailsVO, SpuDetailsQuery, SpuDetailsDO, Long> {


    void add(String content);


}
