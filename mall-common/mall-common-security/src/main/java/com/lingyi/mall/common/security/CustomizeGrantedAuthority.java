package com.lingyi.mall.common.security;

import cn.hutool.core.util.StrUtil;
import com.lingyi.mall.common.constant.BaseConstant;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.security.core.GrantedAuthority;

import java.io.Serial;
import java.util.List;

/**
 * @Author: maweiyan
 * @Email 1107201045@qq.com
 * @DateTime: 2023/5/6 20:40
 * @Description:
 */
public record CustomizeGrantedAuthority(List<String> permissions) implements GrantedAuthority {
    @Serial
    private static final long serialVersionUID = -7601672163147418772L;

    public CustomizeGrantedAuthority(List<String> permissions) {
        this.permissions = permissions;
    }

    @Override
    public String getAuthority() {
        return StrUtil.join(BaseConstant.COMMA_DELIMITER, permissions);
    }

    public static CustomizeGrantedAuthority of(List<String> permissions) {
        return new CustomizeGrantedAuthority(permissions);
    }
}
