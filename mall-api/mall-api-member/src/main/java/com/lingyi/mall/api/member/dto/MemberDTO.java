package com.lingyi.mall.api.member.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/5/25 15:11
 * @description
 */
@Schema(description = "注册")
@Data
public class MemberDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = 4635589772012029338L;

}
