package com.lingyi.mall.biz.product.service.impl;

import com.lingyi.mall.biz.product.dao.mapper.SpuDetailsMapper;
import com.lingyi.mall.biz.product.dao.repository.SpuDetailsRepository;
import com.lingyi.mall.biz.product.model.dto.SpuDetailsDTO;
import com.lingyi.mall.biz.product.model.entity.SpuDetailsDO;
import com.lingyi.mall.biz.product.model.query.SpuDetailsQuery;
import com.lingyi.mall.biz.product.model.vo.SpuDetailsVO;
import com.lingyi.mall.biz.product.service.SpuDetailsService;
import com.lingyi.mall.common.orm.util.BaseServiceProImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @Author: maweiyan
 * @Email: 1107201045@qq.com
 * @DateTime: 2023/12/1 14:09
 * @Description:
 */
@Service
@RequiredArgsConstructor
public class SpuDetailsServiceImpl extends BaseServiceProImpl<SpuDetailsRepository, SpuDetailsMapper,
        SpuDetailsDTO, SpuDetailsVO, SpuDetailsQuery, SpuDetailsDO, Long> implements SpuDetailsService {
}
