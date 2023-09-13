package com.lingyi.mall.biz.product.service.impl;

import com.lingyi.mall.biz.product.dto.SpuDTO;
import com.lingyi.mall.biz.product.entity.SpuDO;
import com.lingyi.mall.biz.product.mapper.SpuMapper;
import com.lingyi.mall.biz.product.param.SpuParam;
import com.lingyi.mall.biz.product.repository.SpuRepository;
import com.lingyi.mall.biz.product.service.SpuService;
import com.lingyi.mall.biz.product.vo.SpuVO;
import com.lingyi.mall.common.orm.param.BasePageParam;
import com.lingyi.mall.common.core.util.ConverterUtil;
import com.lingyi.mall.common.orm.util.BaseServiceProImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: maweiyan
 * @Email: 1107201045@qq.com
 * @DateTime: 2023/8/31 9:29
 * @Description:
 */
@Service
public class SpuServiceImpl extends BaseServiceProImpl<SpuRepository, SpuMapper, SpuDTO, SpuVO, SpuParam, SpuDO, Long> implements SpuService {


}
