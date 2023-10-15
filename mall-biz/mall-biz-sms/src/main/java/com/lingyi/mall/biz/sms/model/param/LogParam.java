package com.lingyi.mall.biz.sms.model.param;

import com.lingyi.mall.common.core.param.BasePageParam;
import io.swagger.v3.oas.annotations.media.Schema;
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
public class LogParam extends BasePageParam {


    @Schema(description = "手机号")
    private String phoneNumber;
}
