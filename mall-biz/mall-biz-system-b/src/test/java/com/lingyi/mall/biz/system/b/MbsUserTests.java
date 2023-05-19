package com.lingyi.mall.biz.system.b;

import cn.hutool.core.util.RandomUtil;
import com.lingyi.mall.MallBizSystemApplicationTests;
import com.lingyi.mall.api.system.b.entity.User;
import com.lingyi.mall.biz.system.b.mapper.MbsUserMapper;
import com.lingyi.mall.biz.system.b.repository.MbsUserRepository;
import com.lingyi.mall.common.base.enums.YNEnum;
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
public class MbsUserTests implements MallBizSystemApplicationTests {
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private MbsUserRepository mbsUserRepository;

    @Autowired
    private MbsUserMapper mbsUserMapper;

    @Test
    public void testUserSave() {
        User user = new User();
        user.setUserName(RandomUtil.randomString(6));
        user.setPassword(passwordEncoder.encode(RandomUtil.randomString(6)));
        user.setIsEnable(YNEnum.Y.getCode());
        user = mbsUserRepository.save(user);
        System.out.println(user);
    }

    @Test
    public void testUserRemove() {
        User user = new User();
        user.setPassword("11");
        mbsUserRepository.delete(user);
        System.out.println("删除成功");
    }

    @Test
    public void testUserUpdate() {
        User user = new User();
        user.setId(5308839368929536L);
        user.setUserName(RandomUtil.randomString(6));
        user.setPassword(passwordEncoder.encode(RandomUtil.randomString(6)));
        user.setIsEnable(YNEnum.Y.getCode());
        user = mbsUserRepository.save(user);
        System.out.println(user);
    }

    @Test
    public void testUserGet() {
        Optional<User> userOptional = mbsUserRepository.findById(5308839368929536L);
        System.out.println(userOptional.orElse(new User()));
    }


}
