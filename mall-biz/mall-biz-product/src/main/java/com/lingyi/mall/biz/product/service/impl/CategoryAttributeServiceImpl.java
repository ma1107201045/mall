package com.lingyi.mall.biz.product.service.impl;

import com.lingyi.mall.biz.product.dto.CategoryAttributeDTO;
import com.lingyi.mall.biz.product.entity.CategoryAttributeDO;
import com.lingyi.mall.biz.product.mapper.CategoryAttributeMapper;
import com.lingyi.mall.biz.product.param.CategoryAttributeParam;
import com.lingyi.mall.biz.product.repository.CategoryAttributeRepository;
import com.lingyi.mall.biz.product.service.CategoryAttributeService;
import com.lingyi.mall.biz.product.vo.CategoryAttributeVO;
import com.lingyi.mall.common.orm.param.BasePageParam;
import com.lingyi.mall.common.core.util.ConverterUtil;
import com.lingyi.mall.common.orm.util.BaseServiceProImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: maweiyan
 * @Email: 1107201045@qq.com
 * @DateTime: 2023/8/31 9:52
 * @Description:
 */
@Service
public class CategoryAttributeServiceImpl extends BaseServiceProImpl<CategoryAttributeRepository, CategoryAttributeMapper, CategoryAttributeDTO, CategoryAttributeVO, CategoryAttributeParam, CategoryAttributeDO, Long>
        implements CategoryAttributeService {

}
