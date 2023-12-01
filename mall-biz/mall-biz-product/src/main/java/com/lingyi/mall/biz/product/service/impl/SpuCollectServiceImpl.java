package com.lingyi.mall.biz.product.service.impl;

import com.lingyi.mall.biz.product.dao.mapper.SpuCollectMapper;
import com.lingyi.mall.biz.product.dao.repository.SpuCollectRepository;
import com.lingyi.mall.biz.product.model.dto.SpuCollectDTO;
import com.lingyi.mall.biz.product.model.entity.SpuCollectDO;
import com.lingyi.mall.biz.product.model.param.SpuCollectParam;
import com.lingyi.mall.biz.product.model.vo.SpuCollectVO;
import com.lingyi.mall.biz.product.service.SpuCollectService;
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
public class SpuCollectServiceImpl extends BaseServiceProImpl<SpuCollectRepository, SpuCollectMapper,
        SpuCollectDTO, SpuCollectVO, SpuCollectParam, SpuCollectDO, Long> implements SpuCollectService {
}
