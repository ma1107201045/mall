package com.lingyi.mall.biz.system.b;

import cn.hutool.core.util.RandomUtil;
import com.lingyi.mall.api.system.b.entity.Role;
import com.lingyi.mall.api.system.b.entity.User;
import com.lingyi.mall.api.system.b.entity.UserRole;
import com.lingyi.mall.biz.system.b.mapper.MbsUserMapper;
import com.lingyi.mall.biz.system.b.repository.MbsRoleRepository;
import com.lingyi.mall.biz.system.b.repository.MbsUserRepository;
import com.lingyi.mall.biz.system.b.repository.MbsUserRoleRepository;
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
        User user = new User();
        user.setUserName("1111");
        user.setPassword("111");
        user.setIsEnable(1);
        user = mbsUserRepository.save(user);
        System.out.println(user);
    }

    @Test
    public void testRole() {
        Role role = new Role();
        role.setIsEnable(1);
        role.setSort(Math.abs(RandomUtil.randomInt()));
        role.setIsDelete(1);
        role = mbsRoleRepository.save(role);
        System.out.println(role);
    }


    @Test
    public void testUserRole() {
        User user = new User();
        user.setUserName("1111");
        user.setPassword("111");
        user.setIsEnable(1);
        user = mbsUserRepository.save(user);
        System.out.println(user);

        Role role = new Role();
        role.setIsEnable(1);
        role.setSort(Math.abs(RandomUtil.randomInt()));
        role.setIsDelete(1);
        role = mbsRoleRepository.save(role);
        System.out.println(role);

        UserRole userRole = new UserRole();
        userRole.setUser(user);
        userRole.setRole(role);
        userRole = mbsUserRoleRepository.save(userRole);
        System.out.println(userRole);
    }

    @Autowired
    private MbsUserMapper mbsUserMapper;

    @Test
    public void testUserOfMybatis() {
        System.out.println(mbsUserMapper);
    }
}
