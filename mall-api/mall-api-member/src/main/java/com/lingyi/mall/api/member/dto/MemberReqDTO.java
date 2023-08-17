package com.lingyi.mall.api.member.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/7/21 9:13
 * @description 会员 Request
 */
@Data
public class MemberReqDTO {

    /**
     * 会员等级id
     */
    private Long memberLevelId;

    /**
     * 用户名称
     */
    private String userName;

    /**
     * 昵称
     */
    private String nickname;

    /**
     * 手机号码
     */
    private String phoneNumber;

    /**
     * 是否启用 1 是 0 否
     */
    private Integer isEnable;

    /**
     * 注册来源 1.H5端 2.Android端 3.IOS端 4.PC端
     */
    private Integer registerSource;

    /**
     * 注册时间
     */
    private LocalDateTime registerDataTime;
}
