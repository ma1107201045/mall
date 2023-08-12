package com.lingyi.mall.api.system.dto;

import lombok.Data;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/6/9 16:10
 * @description 用户
 */
@Data
public class UserPartReqDTO {

    /**
     * 用户id
     */
    private Long id;
    /**
     * 昵称
     */
    private String nickname;
    /**
     * 密码
     */
    private String password;
}
