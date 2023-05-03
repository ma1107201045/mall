package com.lingyi.mall.api.system.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

/**
 * @Author: maweiyan
 * @Email 1107201045@qq.com
 * @DateTime: 2023/5/3 21:32
 * @Description: 获取用户信息以及对应的权限
 */
@Getter
@Setter
@ToString(callSuper = true)
public class MbsUserAndPermissionsVO implements Serializable {
    @Serial
    private static final long serialVersionUID = 1243838317263367362L;

    private String password;

    private Integer isEnabled;

    private List<String> permissions;
}
