package com.lingyi.mall.biz.system;

import com.lingyi.mall.MallBizSystemApplicationTests;
import com.lingyi.mall.biz.system.mapper.RoleMapper;
import com.lingyi.mall.biz.system.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/5/15 15:42
 * @description
 */
@SpringBootTest
public class RoleTests implements MallBizSystemApplicationTests {

    @Autowired
    private RoleRepository mbsRoleRepository;

    @Autowired
    private RoleMapper mbsRoleMapper;
}
