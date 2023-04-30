package com.lingyi.mall.biz.system;

import cn.hutool.core.math.MathUtil;
import cn.hutool.core.util.RandomUtil;
import com.lingyi.mall.biz.system.entity.MbsRole;
import com.lingyi.mall.biz.system.repository.MbsRoleRepository;
import com.lingyi.mall.biz.system.repository.MbsUserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/4/30 17:42
 * @description
 */
@SpringBootTest
public class MallBizSystemApplicationTests {


    @Autowired
    private MbsUserRepository mbsUserRepository;

    @Autowired
    private MbsRoleRepository mbsRoleRepository;


    @Test
    public void testRole() {
        MbsRole mbsRole = new MbsRole();
        mbsRole.setIsEnable(1);
        mbsRole.setSort(Math.abs(RandomUtil.randomInt()));
        mbsRole = mbsRoleRepository.save(mbsRole);
        System.out.println(mbsRole);
    }
}
