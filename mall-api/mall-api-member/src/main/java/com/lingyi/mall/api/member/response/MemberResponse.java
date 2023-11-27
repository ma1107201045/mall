package com.lingyi.mall.api.member.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/6/9 16:47
 * @description 会员 response
 */
@Data
@Schema(description = "会员")
public class MemberResponse {

    /**
     * 会员id
     */
    private Long id;
    /**
     * 会员等级id
     */
    private Long memberLevelId;
    /**
     * 用户名称
     */
    private String userName;
    /**
     * 密码
     */
    private String password;

    /**
     * 昵称
     */
    private String nickname;
    /**
     * 性别：1 男；2 女
     */
    private Integer sex;

    /**
     * 生日
     */
    private LocalDate birthday;

    /**
     * 手机号码
     */
    private String phoneNumber;

    /*
     *头像
     */
    private String headPortrait;

    /**
     * 个性签名
     */
    private String personalizedSignature;

    /**
     * 是否启用 1 是 0 否
     */
    private Integer isEnable;

    /**
     * 注册来源 1.Web端 2.Android端 3.IOS端 4.PC端
     */
    private Integer registerSource;

    /**
     * 注册时间
     */
    private LocalDateTime registerDataTime;
}
