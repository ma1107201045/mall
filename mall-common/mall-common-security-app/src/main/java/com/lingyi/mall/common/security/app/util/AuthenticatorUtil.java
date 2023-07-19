package com.lingyi.mall.common.security.app.util;

import cn.hutool.core.util.StrUtil;
import cn.hutool.jwt.JWT;
import cn.hutool.jwt.JWTUtil;
import com.lingyi.mall.common.base.constant.BaseConstant;
import com.lingyi.mall.common.security.app.entity.MemberDetailsDO;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.Objects;

/**
 * @Author: maweiyan
 * @Email 1107201045@qq.com
 * @DateTime: 2023/7/4 21:22
 * @Description:
 */
public class AuthenticatorUtil {


    /**
     * 获取admin端用户认证信息
     *
     * @return UserDetailsEntity
     */
    public static MemberDetailsDO getMemberDetailsDO() {
        // 获取原请求属性
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        //判空
        if (Objects.isNull(attributes)) {
            return MemberDetailsDO.builder().build();
        }
        // 获取原请求
        HttpServletRequest request = attributes.getRequest();
        String token = request.getHeader(BaseConstant.AUTHORIZATION);
        if (StrUtil.isBlank(token)) {
            return MemberDetailsDO.builder().build();
        }
        JWT jwt = JWTUtil.parseToken(token);
        return jwt.getPayload().getClaimsJson().toBean(MemberDetailsDO.class);
    }

    /**
     * 获取当前认证用户id
     *
     * @return 用户id
     */
    public static Long getUserId() {
        return getMemberDetailsDO().getUserId();
    }

    /**
     * 获取当前认证名用户名称
     *
     * @return 用户名称
     */
    public static String getUserName() {
        return getMemberDetailsDO().getUserName();
    }


    /**
     * 获取当前认证名用户名称
     *
     * @return 用户名称
     */
    public static String getPhoneNumber() {
        return getMemberDetailsDO().getPhoneNumber();
    }
}
