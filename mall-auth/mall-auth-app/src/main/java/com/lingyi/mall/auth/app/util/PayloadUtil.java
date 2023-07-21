package com.lingyi.mall.auth.app.util;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.StrUtil;
import com.lingyi.mall.api.member.dto.MemberRespDTO;
import com.lingyi.mall.common.base.constant.BaseConstant;
import com.lingyi.mall.common.security.app.constant.SecurityConstant;

import java.time.LocalDateTime;
import java.util.Map;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/7/21 15:52
 * @description
 */
public class PayloadUtil {

    /**
     * 签发人
     */
    private static final String ISSUER = "iss";
    /**
     * 过期时间
     */
    private static final String EXPIRATION_TIME = "exp ";
    /**
     * 主题
     */
    private static final String SUBJECT = "sub";
    /**
     * 受众
     */
    private static final String AUDIENCE = "aud";
    /**
     * 生效时间
     */
    private static final String NOT_BEFORE = "nbf";
    /**
     * 签发时间
     */
    private static final String ISSUED_AT = "iat";
    /**
     * 编号
     */
    private static final String JWT_ID = "jti";


    public static Map<String, Object> generate(MemberRespDTO memberRespDTO) {
        LocalDateTime now = LocalDateTime.now();
        Map<String, Object> payload = BeanUtil.beanToMap(memberRespDTO);
        payload.put(ISSUER, memberRespDTO.getUserName());
        payload.put(EXPIRATION_TIME, now.plus(SecurityConstant.TOKEN_EXPIRATION_TIME_VALUE, SecurityConstant.CHRONO_UNIT)
                .format(BaseConstant.DATE_TIME_FORMATTER_DEFAULT));
        payload.put(SUBJECT, StrUtil.EMPTY);
        payload.put(AUDIENCE, StrUtil.EMPTY);
        payload.put(NOT_BEFORE, now.format(BaseConstant.DATE_TIME_FORMATTER_DEFAULT));
        payload.put(ISSUED_AT, now.format(BaseConstant.DATE_TIME_FORMATTER_DEFAULT));
        payload.put(JWT_ID, memberRespDTO.getMemberId());
        return payload;
    }
}
