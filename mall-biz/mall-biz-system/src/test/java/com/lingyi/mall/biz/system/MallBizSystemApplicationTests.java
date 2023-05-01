package com.lingyi.mall.biz.system;

import cn.hutool.core.util.RandomUtil;
import com.lingyi.mall.biz.system.entity.MbsRole;
import com.lingyi.mall.biz.system.entity.MbsUser;
import com.lingyi.mall.biz.system.entity.MbsUserRole;
import com.lingyi.mall.biz.system.repository.MbsRoleRepository;
import com.lingyi.mall.biz.system.repository.MbsUserRepository;
import com.lingyi.mall.biz.system.repository.MbsUserRoleRepository;
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

    @Autowired
    private MbsUserRoleRepository mbsUserRoleRepository;

    @Test
    public void testUser() {
        MbsUser mbsUser = new MbsUser();
        mbsUser.setUserName("1111");
        mbsUser.setPassword("111");
        mbsUser.setIsEnable(1);
        mbsUser = mbsUserRepository.save(mbsUser);
        System.out.println(mbsUser);
    }

    @Test
    public void testRole() {
        MbsRole mbsRole = new MbsRole();
        mbsRole.setIsEnable(1);
        mbsRole.setSort(Math.abs(RandomUtil.randomInt()));
        mbsRole.setIsDelete(1);
        mbsRole = mbsRoleRepository.save(mbsRole);
        System.out.println(mbsRole);
    }


    @Test
    public void testUserRole() {
        MbsUser mbsUser = new MbsUser();
        mbsUser.setUserName("1111");
        mbsUser.setPassword("111");
        mbsUser.setIsEnable(1);
        mbsUser = mbsUserRepository.save(mbsUser);
        System.out.println(mbsUser);

        MbsRole mbsRole = new MbsRole();
        mbsRole.setIsEnable(1);
        mbsRole.setSort(Math.abs(RandomUtil.randomInt()));
        mbsRole.setIsDelete(1);
        mbsRole = mbsRoleRepository.save(mbsRole);
        System.out.println(mbsRole);

        MbsUserRole mbsUserRole = new MbsUserRole();
        mbsUserRole.setMbsUser(mbsUser);
        mbsUserRole.setMbsRole(mbsRole);
        mbsUserRole = mbsUserRoleRepository.save(mbsUserRole);
        System.out.println(mbsUserRole);

    }
}
