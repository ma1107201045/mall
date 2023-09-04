package com.lingyi.mall.web.admin.product;

import cn.hutool.core.util.StrUtil;
import com.lingyi.mall.MallBizProductApplicationTest;
import com.lingyi.mall.biz.product.entity.BrandDO;
import com.lingyi.mall.biz.product.mapper.BrandMapper;
import com.lingyi.mall.biz.product.param.BrandParam;
import com.lingyi.mall.biz.product.repository.BrandRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

/**
 * @Author: maweiyan
 * @Email: 1107201045@qq.com
 * @DateTime: 2023/9/4 14:59
 * @Description:
 */
@SpringBootTest
public class BrandTest implements MallBizProductApplicationTest {

    @Autowired
    private BrandRepository brandRepository;

    @Autowired
    private BrandMapper brandMapper;


    @Test
    public void testSave() {
        BrandDO brandDO = new BrandDO();
        brandDO.setCreateBy("un");
        brandDO.setCreateDateTime(LocalDateTime.now());
        brandDO.setLastModifyBy("un");
        brandDO.setLastModifyDateTime(LocalDateTime.now());
        brandDO.setMerchantId(1L);
        brandDO.setShopId(1L);
        brandDO.setName(StrUtil.EMPTY);
        brandDO.setLogo(StrUtil.EMPTY);
        brandDO.setUserId(1L);
        brandRepository.save(brandDO);
    }

    @Test
    public void testBrandGet() {
        var brandVO = brandMapper.selectById(1L);
        System.out.println(brandVO);
    }

    @Test
    public void testBrandGetList() {
        var brandVOS = brandMapper.selectListByParam(new BrandParam());
        System.out.println(brandVOS);
    }
}
