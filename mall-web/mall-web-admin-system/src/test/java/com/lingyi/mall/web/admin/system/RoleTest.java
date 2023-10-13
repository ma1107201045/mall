package com.lingyi.mall.web.admin.system;

import com.lingyi.mall.MallBizSystemApplicationTest;
import com.lingyi.mall.biz.system.dao.mapper.RoleMapper;
import com.lingyi.mall.biz.system.dao.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/5/15 15:42
 * @description
 */
@SpringBootTest
public class RoleTest implements MallBizSystemApplicationTest {

    @Autowired
    private RoleRepository mbsRoleRepository;

    @Autowired
    private RoleMapper mbsRoleMapper;
}
