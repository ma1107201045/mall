package com.lingyi.mall;

import cn.hutool.core.util.RandomUtil;
import com.lingyi.mall.api.system.entity.Role;
import com.lingyi.mall.api.system.entity.User;
import com.lingyi.mall.api.system.entity.UserRole;
import com.lingyi.mall.biz.system.mapper.MbsUserMapper;
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
        User mbsUser = new User();
        mbsUser.setUserName("1111");
        mbsUser.setPassword("111");
        mbsUser.setIsEnable(1);
        mbsUser = mbsUserRepository.save(mbsUser);
        System.out.println(mbsUser);
    }

    @Test
    public void testRole() {
        Role mbsRole = new Role();
        mbsRole.setIsEnable(1);
        mbsRole.setSort(Math.abs(RandomUtil.randomInt()));
        mbsRole.setIsDelete(1);
        mbsRole = mbsRoleRepository.save(mbsRole);
        System.out.println(mbsRole);
    }


    @Test
    public void testUserRole() {
        User mbsUser = new User();
        mbsUser.setUserName("1111");
        mbsUser.setPassword("111");
        mbsUser.setIsEnable(1);
        mbsUser = mbsUserRepository.save(mbsUser);
        System.out.println(mbsUser);

        Role mbsRole = new Role();
        mbsRole.setIsEnable(1);
        mbsRole.setSort(Math.abs(RandomUtil.randomInt()));
        mbsRole.setIsDelete(1);
        mbsRole = mbsRoleRepository.save(mbsRole);
        System.out.println(mbsRole);

        UserRole mbsUserRole = new UserRole();
        mbsUserRole.setMbsUser(mbsUser);
        mbsUserRole.setMbsRole(mbsRole);
        mbsUserRole = mbsUserRoleRepository.save(mbsUserRole);
        System.out.println(mbsUserRole);
    }

    @Autowired
    private MbsUserMapper mbsUserMapper;

    @Test
    public void testUserOfMybatis() {
        System.out.println(mbsUserMapper);
    }
}
