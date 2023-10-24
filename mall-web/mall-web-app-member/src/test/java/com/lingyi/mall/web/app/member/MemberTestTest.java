package com.lingyi.mall.web.app.member;

import com.lingyi.mall.MallWebAppMemberTest;
import com.lingyi.mall.biz.member.model.entity.MemberDO;
import com.lingyi.mall.biz.member.service.MemberService;
import com.lingyi.mall.common.core.enums.WhetherEnum;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/7/22 10:40
 * @description
 */
@SpringBootTest
public class MemberTestTest implements MallWebAppMemberTest {

    @Resource
    private MemberService memberService;


    @Test
    public void testMemberSave() {
        MemberDO memberDO = new MemberDO();
        memberDO.setUserName("test");
        memberDO.setPhoneNumber("15038233127");
        memberDO.setIsEnable(WhetherEnum.Y.getCode());
        memberDO.setRegisterSource(1);
        memberDO.setRegisterDataTime(LocalDateTime.now());
    }

}
