package com.lingyi.mall.biz.member.query;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/6/2 15:53
 * @description
 */
@Schema(description = "会员")
@Data
public class MemberQuery implements Serializable {
    @Serial
    private static final long serialVersionUID = 2889287473826593426L;

    @Schema(description = "用户名称")
    private String userName;

}
