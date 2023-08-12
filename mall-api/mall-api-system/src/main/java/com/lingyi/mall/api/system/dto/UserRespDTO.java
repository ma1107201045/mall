package com.lingyi.mall.api.system.dto;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/6/9 16:10
 * @description 用户
 */
@Data
public class UserRespDTO {

    /**
     * 用户id
     */
    private Long userId;
    /**
     * 用户名称
     */
    private String userName;
    /**
     * 真实姓名
     */
    private String realName;
    /**
     * 昵称
     */
    private String nickname;
    /**
     * 性别 1 男 2 女
     */
    private Integer sex;
    /**
     * 密码
     */
    private String password;
    /**
     * 头像
     */
    private String headPortrait;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 手机号
     */
    private String phoneNumber;
    /**
     * 最后登录IP
     */
    private String lastLoginIp;
    /**
     * 是否启用 1 是 0 否
     */
    private Integer isEnable;
    /**
     * 备注
     */
    private String remark;
    /**
     * 创建人
     */
    private String createBy;
    /**
     * 创建时间
     */
    private LocalDateTime createDateTime;
    /**
     * 最后一次更新人
     */
    private String lastModifyBy;
    /**
     * 最后一次更新时间
     */
    private LocalDateTime lastModifyDateTime;
    /**
     * 是否删除 1是 0否
     */
    private Integer isDelete;
    /**
     * 角色id集
     */
    private List<Long> roleIds;
    /**
     * 按钮权限标识集
     */
    private List<String> permissions;
}
