package com.lingyi.mall.common.security.app.util;

import cn.hutool.core.util.StrUtil;
import cn.hutool.jwt.JWT;
import cn.hutool.jwt.JWTUtil;
import com.lingyi.mall.common.base.constant.BaseConstant;
import com.lingyi.mall.common.base.util.HttpUtil;
import com.lingyi.mall.common.security.app.constant.SecurityConstant;
import com.lingyi.mall.common.security.app.entity.MemberDetailsDO;
import com.lingyi.mall.common.security.common.util.Authenticator;
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
        String token = HttpUtil.getHeader(SecurityConstant.AUTHORIZATION);
        if (StrUtil.isBlank(token)) {
            return MemberDetailsDO.builder().build();
        }
        return JwtUtil.getJwtPayload(token).getClaimsJson().toBean(MemberDetailsDO.class);
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
     * 获取当前认证名手机号
     *
     * @return 手机号
     */
    public static String getPhoneNumber() {
        return getMemberDetailsDO().getPhoneNumber();
    }
}
