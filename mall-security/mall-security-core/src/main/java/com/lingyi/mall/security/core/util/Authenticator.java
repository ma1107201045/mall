package com.lingyi.mall.security.core.util;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

/**
 * @Author: maweiyan
 * @Email: 1107201045@qq.com
 * @DateTime: 2024/1/16 9:07
 * @Description:
 */
@Data
public class Authenticator implements Serializable {
    @Serial
    private static final long serialVersionUID = 5278928923629167298L;

    private Long currentUserId;

    private String currentUserName;
}
