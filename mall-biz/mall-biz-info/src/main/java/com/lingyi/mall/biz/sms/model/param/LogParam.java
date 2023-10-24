package com.lingyi.mall.biz.sms.model.param;

import com.lingyi.mall.common.core.param.BasePageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/7/13 15:15
 * @description
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class LogParam extends BasePageParam {

    @Schema(description = "服务名称")
    private String serviceName;

    @Schema(description = "业务名称")
    private String businessName;

    @Schema(description = "短信类型 1.通知 2.短信")
    private Integer type;

    @Schema(description = "手机号")
    private String phoneNumber;
}
