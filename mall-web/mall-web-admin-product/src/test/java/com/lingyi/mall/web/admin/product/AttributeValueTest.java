package com.lingyi.mall.web.admin.product;

import com.lingyi.mall.MallBizProductApplicationTest;
import com.lingyi.mall.biz.product.mapper.AttributeValueMapper;
import com.lingyi.mall.biz.product.repository.AttributeValueRepository;
import com.lingyi.mall.biz.product.service.AttributeValueService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.Collections;

/**
 * @Author: maweiyan
 * @Email: 1107201045@qq.com
 * @DateTime: 2023/9/5 15:13
 * @Description:
 */
@SpringBootTest
public class AttributeValueTest implements MallBizProductApplicationTest {


    @Autowired
    private AttributeValueRepository attributeValueRepository;

    @Autowired
    private AttributeValueMapper attributeValueMapper;

    @Autowired
    private TransactionTemplate transactionTemplate;


    @Test
    public void testDelete() {
        transactionTemplate.executeWithoutResult(action -> attributeValueRepository.deleteByAttributeIds(Collections.singletonList(1L)));
    }
}
