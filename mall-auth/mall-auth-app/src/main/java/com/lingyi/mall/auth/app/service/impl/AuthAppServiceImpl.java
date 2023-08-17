package com.lingyi.mall.auth.app.service.impl;

import cn.hutool.core.date.DateUnit;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.net.Ipv4Util;
import cn.hutool.core.util.RandomUtil;
import com.lingyi.mall.api.member.consumer.MemberFeignConsumer;
import com.lingyi.mall.api.member.consumer.MemberLevelFeignConsumer;
import com.lingyi.mall.api.member.consumer.MemberLoginLogFeignConsumer;
import com.lingyi.mall.api.member.dto.MemberLoginLogReqDTO;
import com.lingyi.mall.api.member.dto.MemberReqDTO;
import com.lingyi.mall.api.member.dto.MemberRespDTO;
import com.lingyi.mall.api.sms.consumer.CaptchaFeignConsumer;
import com.lingyi.mall.api.sms.dto.CaptchaSendReqDTO;
import com.lingyi.mall.api.sms.dto.CaptchaVerifyReqDTO;
import com.lingyi.mall.auth.app.converter.AuthAppConverter;
import com.lingyi.mall.auth.app.dto.AuthAppLoginDTO;
import com.lingyi.mall.auth.app.dto.AuthAppSendDTO;
import com.lingyi.mall.auth.app.enums.AuthAppFailEnum;
import com.lingyi.mall.auth.app.properties.SmsCaptchaProperties;
import com.lingyi.mall.auth.app.service.AuthAppService;
import com.lingyi.mall.auth.app.vo.AuthAppLoginVO;
import com.lingyi.mall.common.base.util.AssertUtil;
import com.lingyi.mall.common.base.util.ConverterUtil;
import com.lingyi.mall.common.base.util.HttpUtil;
import com.lingyi.mall.common.redis.util.RedisUtil;
import com.lingyi.mall.common.security.app.constant.SecurityConstant;
import com.lingyi.mall.common.security.app.util.AppRedisKeyUtil;
import com.lingyi.mall.common.security.app.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
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
public class AuthAppServiceImpl implements AuthAppService {

    private final CaptchaFeignConsumer captchaFeignConsumer;

    private final MemberFeignConsumer memberFeignConsumer;

    private final MemberLevelFeignConsumer memberLevelFeignConsumer;

    private final MemberLoginLogFeignConsumer memberLoginLogFeignConsumer;

    private final SmsCaptchaProperties properties;

    private final RedisUtil redisUtil;

    private final AppRedisKeyUtil appRedisKeyUtil;

    @Override
    public void send(AuthAppSendDTO authAppSendDTO) {
        CaptchaSendReqDTO captchaSendReqDTO = AuthAppConverter.INSTANCE.to(authAppSendDTO.getPhoneNumber(), properties);
        captchaFeignConsumer.send(captchaSendReqDTO);
    }

    @Override
    public AuthAppLoginVO login(AuthAppLoginDTO authAppLoginDTO) {
        //转换数据并且校验短信验证码
        CaptchaVerifyReqDTO captchaVerifyReqDTO = AuthAppConverter.INSTANCE.to(authAppLoginDTO, properties);
        captchaFeignConsumer.verify(captchaVerifyReqDTO);

        //通过手机号校验用户是否存在，不存在注册
        MemberRespDTO memberRespDTO = memberFeignConsumer.getByPhoneNumber(authAppLoginDTO.getPhoneNumber());
        if (Objects.isNull(memberRespDTO)) {
            Long memberLevelId = memberLevelFeignConsumer.getDefaultLevelId();
            AssertUtil.notNull(memberLevelId, AuthAppFailEnum.MEMBER_DEFAULT_LEVEL_ID_NULL_ERROR);

            //组装会员信息
            MemberReqDTO memberReqDTO = AuthAppConverter.INSTANCE.to(authAppLoginDTO, memberLevelId);
            //注册会员
            Long id = memberFeignConsumer.register(memberReqDTO);

            //转换数据
            memberRespDTO = ConverterUtil.to(memberReqDTO, MemberRespDTO.class);
            memberRespDTO.setId(id);
        }

        //组装会员登录日志
        MemberLoginLogReqDTO memberLoginLogReqDTO = AuthAppConverter.INSTANCE.to(memberRespDTO);
        //保存会员登录日志
        memberLoginLogFeignConsumer.save(memberLoginLogReqDTO);

        //创建token
        String token = JwtUtil.createToken(memberRespDTO);

        //设置返回头token
        HttpUtil.addHeader(SecurityConstant.AUTHORIZATION, token);
        return ConverterUtil.to(memberRespDTO, AuthAppLoginVO.class);
    }

    @Override
    public void logout() {
        String token = HttpUtil.getHeader(SecurityConstant.AUTHORIZATION);
        long expiryDate = DateUtil.between(JwtUtil.getJwtPayloadExp(token), DateUtil.date(), DateUnit.SECOND);
        String tokenBlacklistKey = appRedisKeyUtil.getTokenBlacklistKey(token);
        redisUtil.set(tokenBlacklistKey, RandomUtil.randomInt(), expiryDate, TimeUnit.MINUTES);
    }


}
