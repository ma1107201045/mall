package com.lingyi.mall.auth.app.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.jwt.JWTUtil;
import com.lingyi.mall.api.member.consumer.MemberFeignConsumer;
import com.lingyi.mall.api.member.dto.MemberRespDTO;
import com.lingyi.mall.auth.app.dto.AppLoginDTO;
import com.lingyi.mall.auth.app.service.AppService;
import com.lingyi.mall.auth.app.vo.AppLoginVO;
import com.lingyi.mall.common.base.util.ConverterUtil;
import com.lingyi.mall.common.security.app.constant.SecurityAppConstant;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.util.Objects;

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
        String phoneNumber = appLoginDTO.getPhoneNumber();
        //TODO 验证码逻辑
        //手机号查询用会员
        MemberRespDTO memberRespDTO = memberFeignConsumer.getByPhoneNumber(phoneNumber);
        //断言用户是否存在
        //AssertUtil.notNull(memberRespDTO, FailEnum.PHONE_NUMBER_NOT_FOUND_ERROR);
        if (Objects.isNull(memberRespDTO)) {
            memberFeignConsumer.save(phoneNumber);
        }
        //生成token
        String token = JWTUtil.createToken(BeanUtil.beanToMap(memberRespDTO), SecurityAppConstant.JWT_KEY.getBytes(StandardCharsets.UTF_8));
        AppLoginVO appLoginVO = ConverterUtil.to(memberRespDTO, AppLoginVO.class);
        appLoginVO.setAuthorization(token);
        return appLoginVO;
    }


    @Override
    public void sendSmsCaptcha(String phoneNumber) {

    }
}
