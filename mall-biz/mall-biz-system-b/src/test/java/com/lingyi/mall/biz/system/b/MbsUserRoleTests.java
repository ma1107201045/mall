package com.lingyi.mall.biz.system.b;

import com.lingyi.mall.MallBizSystemApplicationTests;
import com.lingyi.mall.api.system.b.entity.User;
import com.lingyi.mall.api.system.b.entity.UserRole;
import com.lingyi.mall.biz.system.b.repository.MbsUserRepository;
import com.lingyi.mall.biz.system.b.repository.MbsUserRoleRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/5/15 15:43
 * @description
 */
@SpringBootTest
public class MbsUserRoleTests implements MallBizSystemApplicationTests {


    @Autowired
    private MbsUserRoleRepository mbsUserRoleRepository;

    @Test
    @Transactional
    public void testUserRemove() {
        mbsUserRoleRepository.deleteByUserId(111L);
        System.out.println("删除成功");
    }
}
