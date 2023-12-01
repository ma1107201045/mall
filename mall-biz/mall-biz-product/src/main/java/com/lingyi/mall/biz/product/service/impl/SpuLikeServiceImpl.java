package com.lingyi.mall.biz.product.service.impl;

import com.lingyi.mall.biz.product.dao.mapper.SpuLikeMapper;
import com.lingyi.mall.biz.product.dao.repository.SpuLikeRepository;
import com.lingyi.mall.biz.product.model.dto.SpuLikeDTO;
import com.lingyi.mall.biz.product.model.entity.SpuLikeDO;
import com.lingyi.mall.biz.product.model.param.SpuLikeParam;
import com.lingyi.mall.biz.product.model.vo.SpuLikeVO;
import com.lingyi.mall.biz.product.service.SpuLikeService;
import com.lingyi.mall.common.orm.util.BaseServiceProImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @Author: maweiyan
 * @Email: 1107201045@qq.com
 * @DateTime: 2023/12/1 14:08
 * @Description:
 */
@Service
@RequiredArgsConstructor
public class SpuLikeServiceImpl extends BaseServiceProImpl<SpuLikeRepository, SpuLikeMapper,
        SpuLikeDTO, SpuLikeVO, SpuLikeParam, SpuLikeDO, Long> implements SpuLikeService {
}
