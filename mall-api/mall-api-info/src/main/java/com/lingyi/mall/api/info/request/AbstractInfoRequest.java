package com.lingyi.mall.api.info.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

/**
 * @Author: maweiyan
 * @Email 1107201045@qq.com
 * @DateTime: 2023/10/15 15:35
 * @Description:
 */
@Data
public abstract class AbstractInfoRequest {

    /**
     * 服务类型
     */
    @Schema(description = "服务类型", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "服务类型不能为空")
    private Integer serviceType;

    /**
     * 业务类型
     */
    @Schema(description = "业务类型", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "业务类型不能为空")
    private Integer businessType;

    /**
     * 号码（手机号或者邮箱）
     */
    @Schema(description = "号码（手机号或者邮箱）", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotBlank(message = "号码不能为空")
    private String number;

    /**
     * 短信类型 1.短信 2.短信验证码
     */
    @Schema(description = " 类型 1.短信 2.短信验证码 3.邮箱 4.邮箱验证码", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "类型不能为空")
    private Integer type;
}
