package com.lingyi.mall.biz.system;

import com.lingyi.mall.MallBizSystemApplicationTests;
import com.lingyi.mall.biz.system.repository.UserRoleRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/5/15 15:43
 * @description
 */
@SpringBootTest
public class UserRoleTests implements MallBizSystemApplicationTests {


    @Autowired
    private UserRoleRepository mbsUserRoleRepository;

    @Test
    @Transactional(rollbackFor = Exception.class)
    public void testUserRemove() {
        mbsUserRoleRepository.deleteByUserId(111L);
        System.out.println("删除成功");
    }
}
