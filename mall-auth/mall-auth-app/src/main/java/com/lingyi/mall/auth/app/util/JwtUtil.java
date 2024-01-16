package com.lingyi.mall.auth.app.util;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.date.DateField;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.jwt.JWT;
import cn.hutool.jwt.JWTHeader;
import cn.hutool.jwt.JWTPayload;
import cn.hutool.jwt.JWTUtil;
import cn.hutool.jwt.signers.JWTSigner;
import com.lingyi.mall.api.member.response.MemberResponse;

import java.nio.charset.StandardCharsets;
import java.util.Date;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/7/21 15:52
 * @description
 */
public class JwtUtil {


    public static String createToken(MemberResponse memberResponse) {
        var map = BeanUtil.beanToMap(memberResponse);
        var date = new Date();
        var jwtPayload = new JWTPayload();
        jwtPayload.addPayloads(map);
        jwtPayload.setIssuer(memberResponse.getUserName());
        jwtPayload.setSubject(StrUtil.EMPTY);
        jwtPayload.setAudience(StrUtil.EMPTY);
        jwtPayload.setNotBefore(date);
        jwtPayload.setIssuedAt(date);
        jwtPayload.setExpiresAt(DateUtil.offset(date, DateField.MINUTE, 6));
        jwtPayload.setJWTId(memberResponse.getId().toString());
        return JWTUtil.createToken(jwtPayload.getClaimsJson(), "199726ma.".getBytes(StandardCharsets.UTF_8));
    }

    public static boolean verifyToken(String token) {
        return JWTUtil.verify(token, "199726ma.".getBytes(StandardCharsets.UTF_8));
    }

    public static JWT parseToken(String token) {
        return JWTUtil.parseToken(token);
    }


    public static JWTHeader getJwtHeader(String token) {
        return parseToken(token).getHeader();
    }

    public static JWTPayload getJwtPayload(String token) {
        return parseToken(token).getPayload();
    }

    public static JWTSigner getSigner(String token) {
        return parseToken(token).getSigner();
    }


    public static Date getJwtPayloadExp(String token) {
        return new Date(((Number) getJwtPayload(token).getClaim(JWTPayload.EXPIRES_AT)).longValue() * 1000L);
    }

    public static String getJwtPayloadPhoneNumber(String token) {
        return (String) getJwtPayload(token).getClaim("phoneNumber");
    }
}
