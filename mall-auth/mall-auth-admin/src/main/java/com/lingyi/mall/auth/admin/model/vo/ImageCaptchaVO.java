package com.lingyi.mall.auth.admin.model.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @Author: maweiyan
 * @Email: 1107201045@qq.com
 * @DateTime: 2024/1/10 9:34
 * @Description:
 */
@Data
@Schema
public class ImageCaptchaVO {

    @Schema(description = "UUID,登录前端需要传上来")
    private String uuid;

    @Schema(description = "base64图形验证码")
    private String base64ImageCaptcha;
}
