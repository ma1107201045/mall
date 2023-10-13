package com.lingyi.mall.web.admin.system;

import com.lingyi.mall.MallBizSystemApplicationTest;
import com.lingyi.mall.biz.system.dao.repository.UserRoleRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/5/15 15:43
 * @description
 */
@SpringBootTest
public class UserRoleTest implements MallBizSystemApplicationTest {


    @Autowired
    private UserRoleRepository userRoleRepository;

    @Test
    @Transactional(rollbackFor = Exception.class)
    public void testUserRemove() {
        userRoleRepository.deleteByUserIds(Collections.singletonList(111L));
        System.out.println("删除成功");
    }
}
