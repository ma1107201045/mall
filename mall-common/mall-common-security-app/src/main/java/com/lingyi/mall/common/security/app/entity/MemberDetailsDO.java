package com.lingyi.mall.common.security.app.entity;

import lombok.Builder;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

/**
 * @Author: maweiyan
 * @Email 1107201045@qq.com
 * @DateTime: 2023/5/27 10:38
 * @Description:
 */
@Data
@Builder
public class MemberDetailsDO implements Serializable {
    @Serial
    private static final long serialVersionUID = -4555073638396468898L;

    private Long userId;

    private String userName;

    private String phoneNumber;

}
