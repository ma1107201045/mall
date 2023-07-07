package com.lingyi.mall.auth.app.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.jwt.JWTUtil;
import com.lingyi.mall.api.member.consumer.MemberFeignConsumer;
import com.lingyi.mall.api.member.dto.MemberRespDTO;
import com.lingyi.mall.auth.app.dto.AppLoginDTO;
import com.lingyi.mall.auth.app.dto.AppRegisterDTO;
import com.lingyi.mall.auth.app.service.AppService;
import com.lingyi.mall.auth.app.vo.AppLoginVO;
import com.lingyi.mall.common.base.util.AssertUtil;
import com.lingyi.mall.common.security.app.constant.SecurityAppConstant;
import com.lingyi.mall.common.security.app.enums.FailEnum;
import com.lingyi.mall.common.base.util.ConverterUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/5/25 15:50
 * @description
 */
@Service
@RequiredArgsConstructor
public class AppServiceImpl implements AppService {


    private final MemberFeignConsumer memberFeignConsumer;

    @Override
    public AppLoginVO login(AppLoginDTO appLoginDTO) {
        //TODO 验证码逻辑
        //手机号查询用会员
        MemberRespDTO memberRespDTO = memberFeignConsumer.getByPhoneNumber(appLoginDTO.getPhoneNumber());
        //断言用户是否存在
        AssertUtil.notNull(memberRespDTO, FailEnum.PHONE_NUMBER_NOT_FOUND_ERROR);
        //生成token
        String token = JWTUtil.createToken(BeanUtil.beanToMap(memberRespDTO), SecurityAppConstant.JWT_KEY.getBytes(StandardCharsets.UTF_8));
        AppLoginVO appLoginVO = ConverterUtil.to(memberRespDTO, AppLoginVO.class);
        appLoginVO.setAuthorization(token);
        return appLoginVO;
    }

    @Override
    public void register(AppRegisterDTO appRegisterDTO) {

    }

    @Override
    public void sendVerificationCode(String phoneNumber) {

    }
}
