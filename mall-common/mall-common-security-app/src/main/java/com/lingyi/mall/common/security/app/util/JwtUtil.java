package com.lingyi.mall.common.security.app.util;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.date.DateField;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.jwt.JWT;
import cn.hutool.jwt.JWTHeader;
import cn.hutool.jwt.JWTPayload;
import cn.hutool.jwt.JWTUtil;
import cn.hutool.jwt.signers.JWTSigner;
import com.lingyi.mall.api.member.dto.MemberRespDTO;
import com.lingyi.mall.common.security.app.constant.SecurityConstant;

import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.Map;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/7/21 15:52
 * @description
 */
public class JwtUtil {


    public static String createToken(MemberRespDTO memberRespDTO) {
        var map = BeanUtil.beanToMap(memberRespDTO);
        var date = new Date();
        var jwtPayload = new JWTPayload();
        jwtPayload.addPayloads(map);
        jwtPayload.setIssuer(memberRespDTO.getUserName());
        jwtPayload.setSubject(StrUtil.EMPTY);
        jwtPayload.setAudience(StrUtil.EMPTY);
        jwtPayload.setNotBefore(date);
        jwtPayload.setIssuedAt(date);
        jwtPayload.setExpiresAt(DateUtil.offset(date, DateField.MINUTE, SecurityConstant.TOKEN_EXPIRATION_TIME_VALUE));
        jwtPayload.setJWTId(memberRespDTO.getId().toString());
        return JWTUtil.createToken(jwtPayload.getClaimsJson(), SecurityConstant.JWT_KEY.getBytes(StandardCharsets.UTF_8));
    }

    public static boolean verifyToken(String token) {
        return JWTUtil.verify(token, SecurityConstant.JWT_KEY.getBytes(StandardCharsets.UTF_8));
    }

    public static JWT parseToken(String token) {
        return JWTUtil.parseToken(token);
    }


    public static JWTHeader getJwtHeader(String token) {
        return parseToken(token).getHeader();
    }

    public static JWTPayload getJwtPayload(String token) {
        return JWTUtil.parseToken(token).getPayload();
    }

    public static JWTSigner getSigner(String token) {
        return parseToken(token).getSigner();
    }


    public static Date getJwtPayloadExp(String token) {
        return new Date(((Number) getJwtPayload(token).getClaim(JWTPayload.EXPIRES_AT)).longValue() * 1000L);
    }

    public static String getJwtPayloadPhoneNumber(String token) {
        return (String) getJwtPayload(token).getClaim(SecurityConstant.PHONE_NUMBER);
    }
}
