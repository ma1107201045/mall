package com.lingyi.mall.common.security.app.util;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.date.DateField;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.jwt.JWTPayload;
import cn.hutool.jwt.JWTUtil;
import com.lingyi.mall.api.member.dto.MemberRespDTO;
import com.lingyi.mall.common.security.app.constant.SecurityConstant;

import java.util.Date;
import java.util.Map;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/7/21 15:52
 * @description
 */
public class PayloadUtil {


    public static Map<String, Object> generate(MemberRespDTO memberRespDTO) {
        Date date = new Date();
        Map<String, Object> map = BeanUtil.beanToMap(memberRespDTO);
        JWTPayload jwtPayload = new JWTPayload();
        jwtPayload.addPayloads(map);
        jwtPayload.setIssuer(memberRespDTO.getUserName());
        jwtPayload.setSubject(StrUtil.EMPTY);
        jwtPayload.setAudience(StrUtil.EMPTY);
        jwtPayload.setNotBefore(date);
        jwtPayload.setIssuedAt(date);
        jwtPayload.setExpiresAt(DateUtil.offset(date, DateField.MINUTE, SecurityConstant.TOKEN_EXPIRATION_TIME_VALUE));
        jwtPayload.setJWTId(String.valueOf(memberRespDTO.getMemberId()));
        return jwtPayload.getClaimsJson();
    }

    public static JWTPayload getJwtPayload(String token) {
        return JWTUtil.parseToken(token).getPayload();
    }

    public static Date getExp(String token) {
        return new Date(((Number) getJwtPayload(token).getClaim(JWTPayload.EXPIRES_AT)).longValue() * 1000L);
    }

    public static String getPhoneNumber(String token) {
        return (String) getJwtPayload(token).getClaim(SecurityConstant.PHONE_NUMBER);
    }
}
