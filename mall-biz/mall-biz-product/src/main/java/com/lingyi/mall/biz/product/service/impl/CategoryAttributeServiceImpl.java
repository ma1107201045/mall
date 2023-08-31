package com.lingyi.mall.biz.product.service.impl;

import com.lingyi.mall.biz.product.mapper.CategoryAttributeMapper;
import com.lingyi.mall.biz.product.repository.CategoryAttributeRepository;
import com.lingyi.mall.biz.product.service.CategoryAttributeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @Author: maweiyan
 * @Email: 1107201045@qq.com
 * @DateTime: 2023/8/31 9:52
 * @Description:
 */
@Service
@RequiredArgsConstructor
public class CategoryAttributeServiceImpl implements CategoryAttributeService {

    private final CategoryAttributeRepository categoryAttributeRepository;

    private final CategoryAttributeMapper categoryAttributeMapper;
}
