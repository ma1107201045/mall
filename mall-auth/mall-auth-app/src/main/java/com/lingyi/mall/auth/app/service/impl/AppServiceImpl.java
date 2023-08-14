package com.lingyi.mall.auth.app.service.impl;

import cn.hutool.core.date.DateUnit;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.RandomUtil;
import com.lingyi.mall.api.member.consumer.MemberFeignConsumer;
import com.lingyi.mall.api.member.consumer.MemberLevelFeignConsumer;
import com.lingyi.mall.api.member.dto.MemberReqDTO;
import com.lingyi.mall.api.member.dto.MemberRespDTO;
import com.lingyi.mall.api.sms.consumer.CaptchaFeignConsumer;
import com.lingyi.mall.api.sms.dto.CaptchaSendReqDTO;
import com.lingyi.mall.api.sms.dto.CaptchaVerifyReqDTO;
import com.lingyi.mall.auth.app.converter.AppConverter;
import com.lingyi.mall.auth.app.dto.AppLoginDTO;
import com.lingyi.mall.auth.app.dto.AppSendDTO;
import com.lingyi.mall.auth.app.enums.AppFailEnum;
import com.lingyi.mall.auth.app.properties.SmsCaptchaProperties;
import com.lingyi.mall.auth.app.service.AppService;
import com.lingyi.mall.auth.app.vo.AppLoginVO;
import com.lingyi.mall.common.base.util.AssertUtil;
import com.lingyi.mall.common.base.util.ConverterUtil;
import com.lingyi.mall.common.base.util.HttpUtil;
import com.lingyi.mall.common.cache.util.RedisUtil;
import com.lingyi.mall.common.security.app.constant.SecurityConstant;
import com.lingyi.mall.common.security.app.util.AppRedisKeyUtil;
import com.lingyi.mall.common.security.app.util.JwtUtil;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

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

    private final MemberLevelFeignConsumer memberLevelFeignConsumer;

    private final CaptchaFeignConsumer captchaFeignConsumer;

    private final SmsCaptchaProperties properties;

    private final RedisUtil redisUtil;

    private final AppRedisKeyUtil appRedisKeyUtil;

    @Override
    public void send(AppSendDTO appSendDTO) {
        CaptchaSendReqDTO captchaSendReqDTO = AppConverter.INSTANCE.to(appSendDTO.getPhoneNumber(), properties);
        captchaFeignConsumer.send(captchaSendReqDTO);
    }

    @Override
    public AppLoginVO login(AppLoginDTO appLoginDTO) {
        //转换数据并且校验短信验证码
        CaptchaVerifyReqDTO captchaVerifyReqDTO = AppConverter.INSTANCE.to(appLoginDTO, properties);
        captchaFeignConsumer.verify(captchaVerifyReqDTO);

        //通过手机号校验用户是否存在，不存在注册
        MemberRespDTO memberRespDTO = memberFeignConsumer.getByPhoneNumber(appLoginDTO.getPhoneNumber());
        if (Objects.isNull(memberRespDTO)) {
            Long memberLevelId = memberLevelFeignConsumer.getDefaultLevelId();
            AssertUtil.notNull(memberLevelId, AppFailEnum.MEMBER_DEFAULT_LEVEL_ID_NULL_ERROR);
            //注册会员
            MemberReqDTO memberReqDTO = AppConverter.INSTANCE.to(appLoginDTO, memberLevelId);
            memberFeignConsumer.register(memberReqDTO);
            //转换数据
            memberRespDTO = ConverterUtil.to(memberReqDTO, MemberRespDTO.class);
        }
        //创建token
        String token = JwtUtil.createToken(memberRespDTO);
        
        //设置返回头token
        HttpUtil.addHeader(SecurityConstant.AUTHORIZATION, token);
        return ConverterUtil.to(memberRespDTO, AppLoginVO.class);
    }

    @Override
    public void logout() {
        String token = HttpUtil.getHeader(SecurityConstant.AUTHORIZATION);
        Date expiresAt = JwtUtil.getJwtPayloadExp(token);
        long expiryDate = DateUtil.between(expiresAt, DateUtil.date(), DateUnit.SECOND);
        String tokenBlacklistKey = appRedisKeyUtil.getTokenBlacklistKey(token);
        redisUtil.set(tokenBlacklistKey, RandomUtil.randomInt(), expiryDate, TimeUnit.MINUTES);
    }


}
