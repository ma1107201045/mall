package com.lingyi.mall.biz.product.service.impl;

import com.lingyi.mall.biz.product.mapper.AttributeValueMapper;
import com.lingyi.mall.biz.product.repository.AttributeValueRepository;
import com.lingyi.mall.biz.product.service.AttributeValueService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @Author: maweiyan
 * @Email: 1107201045@qq.com
 * @DateTime: 2023/8/31 9:48
 * @Description:
 */
@Service
@RequiredArgsConstructor
public class AttributeValueServiceImpl implements AttributeValueService {


    private final AttributeValueRepository attributeValueRepository;

    private final AttributeValueMapper attributeValueMapper;
}
