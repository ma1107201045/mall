package com.lingyi.mall.biz.sms.param;

import com.lingyi.mall.common.base.param.BasePageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/7/13 15:15
 * @description
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class CaptchaLogParam extends BasePageParam {


    @Schema(description = "手机号")
    private String phoneNumber;
}
