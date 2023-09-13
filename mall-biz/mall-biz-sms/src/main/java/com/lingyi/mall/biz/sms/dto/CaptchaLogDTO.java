package com.lingyi.mall.biz.sms.dto;

import com.lingyi.mall.common.orm.dto.BaseIdDTO;
import com.lingyi.mall.common.orm.vo.BaseIdVO;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serial;

/**
 * @Author: maweiyan
 * @Email: 1107201045@qq.com
 * @DateTime: 2023/9/12 12:28
 * @Description:
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Schema
public class CaptchaLogDTO extends BaseIdDTO<Long> {

    @Serial
    private static final long serialVersionUID = -8254294466774665611L;

    @Schema(description = "服务名称")
    private String serviceName;

    @Schema(description = "业务名称")
    private String businessName;

    @Schema(description = "手机号")
    private String phoneNumber;

    @Schema(description = "验证码")
    private Integer captcha;

    @Schema(description = "验证码长度")
    private Integer length;

    @Schema(description = "验证码有效期 （分钟）")
    private Integer expiryDate;

    @Schema(description = "验证码发送间隔时间（分钟）")
    private Integer intervalDate;

    @Schema(description = "验证码每天上限")
    private Integer upperLimit;

    @Schema(description = "是否成功 1.是 0.否")
    private Integer isSuccess;

    @Schema(description = "失败信息")
    private String failMessage;

    @Schema(description = "备注")
    private String remark;
}
