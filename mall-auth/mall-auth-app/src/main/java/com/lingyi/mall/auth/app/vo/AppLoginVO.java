package com.lingyi.mall.auth.app.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/5/25 16:05
 * @description
 */
@Schema(description = "登录")
@Data
public class AppLoginVO {

    @Schema(description = "authorization")
    private String authorization;
}
