package com.lingyi.mall.biz.member.dto;

import com.lingyi.mall.common.orm.dto.BaseIdDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;
import java.time.LocalDateTime;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/5/25 15:11
 * @description
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Schema(description = "会员")
public class MemberDTO extends BaseIdDTO<Long> {

    @Serial
    private static final long serialVersionUID = -3560384472754676701L;
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
