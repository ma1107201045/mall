package com.lingyi.mall.biz.member.dto;

import com.lingyi.mall.common.orm.dto.BaseIdDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;

/**
 * @Author: maweiyan
 * @Email: 1107201045@qq.com
 * @DateTime: 2023/9/13 9:22
 * @Description:
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Schema(description = "会员等级")
public class MemberLevelDTO extends BaseIdDTO<Long> {
    @Serial
    private static final long serialVersionUID = -1567531210110233969L;
}
