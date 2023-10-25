package com.lingyi.mall.auth.app.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/8/12 10:18
 * @description
 */
@Schema(description = "发送")
@Data
public class AuthAppSendDTO {

    @Schema(description = "号码")
    @NotBlank(message = "号码不能为空")
    private String number;
}
