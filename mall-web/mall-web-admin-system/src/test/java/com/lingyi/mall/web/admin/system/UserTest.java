package com.lingyi.mall.web.admin.system;

import cn.hutool.core.util.RandomUtil;
import com.lingyi.mall.MallBizSystemApplicationTest;
import com.lingyi.mall.biz.system.entity.UserDO;
import com.lingyi.mall.biz.system.mapper.UserMapper;
import com.lingyi.mall.biz.system.repository.UserRepository;
import com.lingyi.mall.common.base.enums.WhetherEnum;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/4/30 17:42
 * @description
 */
@SpringBootTest
public class UserTest implements MallBizSystemApplicationTest {
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testUserSave() {
        UserDO userDO = new UserDO();
        userDO.setUserName(RandomUtil.randomString(6));
        userDO.setPassword(passwordEncoder.encode(RandomUtil.randomString(6)));
        userDO.setIsEnable(WhetherEnum.Y.getCode());
        userDO = userRepository.save(userDO);
        System.out.println(userDO);
    }

    @Test
    public void testUserRemove() {
        UserDO userDO = new UserDO();
        userDO.setPassword("11");
        userRepository.delete(userDO);
        System.out.println("删除成功");
    }

    @Test
    public void testUserUpdate() {
        UserDO userDO = new UserDO();
        userDO.setId(5308839368929536L);
        userDO.setUserName(RandomUtil.randomString(6));
        userDO.setPassword(passwordEncoder.encode(RandomUtil.randomString(6)));
        userDO.setIsEnable(WhetherEnum.Y.getCode());
        userDO = userRepository.save(userDO);
        System.out.println(userDO);
    }

    @Test
    public void testUserGet() {
        Optional<UserDO> userOptional = userRepository.findById(5308839368929536L);
        System.out.println(userOptional.orElse(new UserDO()));
    }


}
