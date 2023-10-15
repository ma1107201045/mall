package com.lingyi.mall.auth.app.service.impl;

import cn.hutool.core.date.DateUnit;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.RandomUtil;
import com.lingyi.mall.api.member.consumer.MemberFeignConsumer;
import com.lingyi.mall.api.member.consumer.MemberLevelFeignConsumer;
import com.lingyi.mall.api.member.consumer.MemberLoginLogFeignConsumer;
import com.lingyi.mall.api.member.dto.MemberRespDTO;
import com.lingyi.mall.api.sms.consumer.SmsFeignConsumer;
import com.lingyi.mall.auth.app.converter.AuthAppConverter;
import com.lingyi.mall.auth.app.model.dto.AuthAppLoginDTO;
import com.lingyi.mall.auth.app.model.dto.AuthAppSendDTO;
import com.lingyi.mall.auth.app.enums.AuthAppFailEnum;
import com.lingyi.mall.auth.app.properties.SmsCaptchaProperties;
import com.lingyi.mall.auth.app.service.AuthAppService;
import com.lingyi.mall.auth.app.model.vo.AuthAppLoginVO;
import com.lingyi.mall.common.core.util.AssertUtil;
import com.lingyi.mall.common.core.util.ConverterUtil;
import com.lingyi.mall.common.core.util.HttpUtil;
import com.lingyi.mall.common.redis.util.RedisUtil;
import com.lingyi.mall.security.app.constant.SecurityConstant;
import com.lingyi.mall.security.app.util.JwtUtil;
import com.lingyi.mall.security.app.util.RedisKeyUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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

    private final SmsFeignConsumer smsFeignConsumer;

    private final MemberFeignConsumer memberFeignConsumer;

    private final MemberLevelFeignConsumer memberLevelFeignConsumer;

    private final MemberLoginLogFeignConsumer memberLoginLogFeignConsumer;

    private final SmsCaptchaProperties properties;

    private final RedisUtil redisUtil;

    private final RedisKeyUtil redisKeyUtil;

    @Override
    public void sendSmsCaptcha(AuthAppSendDTO authAppSendDTO) {
        var captchaSendReqDTO = AuthAppConverter.INSTANCE.to(authAppSendDTO.getPhoneNumber(), properties);
        smsFeignConsumer.sendCaptcha(captchaSendReqDTO);
    }

    @Override
    public void sendEmailCaptcha() {

    }

    @Override
    public AuthAppLoginVO login(AuthAppLoginDTO authAppLoginDTO) {
        //转换数据并且校验短信验证码
        var captchaVerifyReqDTO = AuthAppConverter.INSTANCE.to(authAppLoginDTO, properties);
        smsFeignConsumer.verifyCaptcha(captchaVerifyReqDTO);

        //通过手机号校验用户是否存在，不存在注册
        var memberRespDTO = memberFeignConsumer.getByPhoneNumber(authAppLoginDTO.getPhoneNumber());
        if (Objects.isNull(memberRespDTO)) {
            var memberLevelId = memberLevelFeignConsumer.getDefaultLevelId();
            AssertUtil.notNull(memberLevelId, AuthAppFailEnum.MEMBER_DEFAULT_LEVEL_ID_NULL_ERROR);

            //组装会员信息
            var memberReqDTO = AuthAppConverter.INSTANCE.to(authAppLoginDTO, memberLevelId);
            //注册会员
            Long id = memberFeignConsumer.register(memberReqDTO);

            //转换数据
            memberRespDTO = ConverterUtil.to(memberReqDTO, MemberRespDTO.class);
            memberRespDTO.setId(id);
        }

        //组装会员登录日志
        var memberLoginLogReqDTO = AuthAppConverter.INSTANCE.to(memberRespDTO);
        //保存会员登录日志
        memberLoginLogFeignConsumer.save(memberLoginLogReqDTO);

        //创建token
        var token = JwtUtil.createToken(memberRespDTO);

        //设置返回头token
        HttpUtil.setHeader(SecurityConstant.AUTHORIZATION, token);
        return ConverterUtil.to(memberRespDTO, AuthAppLoginVO.class);
    }

    @Override
    public void logout() {
        var token = HttpUtil.getHeader(SecurityConstant.AUTHORIZATION);
        long expiryDate = DateUtil.between(JwtUtil.getJwtPayloadExp(token), DateUtil.date(), DateUnit.SECOND);
        var tokenBlacklistKey = redisKeyUtil.getTokenBlacklistKey(token);
        redisUtil.set(tokenBlacklistKey, RandomUtil.randomInt(), expiryDate, TimeUnit.MINUTES);
    }


}
