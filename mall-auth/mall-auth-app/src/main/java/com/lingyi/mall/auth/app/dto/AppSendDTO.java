package com.lingyi.mall.auth.app.dto;

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
public class AppSendDTO {

    @Schema(description = "手机号")
    @NotBlank(message = "手机号不能为空")
    private String phoneNumber;
}
