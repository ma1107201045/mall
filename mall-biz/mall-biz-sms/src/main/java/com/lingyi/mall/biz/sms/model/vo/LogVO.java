package com.lingyi.mall.biz.sms.model.vo;

import com.lingyi.mall.common.core.vo.BaseIdVO;
import io.swagger.v3.oas.annotations.media.Schema;

import java.io.Serial;
import java.time.LocalDateTime;

/**
 * @Author: maweiyan
 * @Email: 1107201045@qq.com
 * @DateTime: 2023/9/12 12:28
 * @Description:
 */
public class LogVO extends BaseIdVO<Long> {
    @Serial
    private static final long serialVersionUID = 4041786744709139228L;


    @Schema(description = "服务名称")
    private String serviceName;

    @Schema(description = "业务名称")
    private String businessName;

    @Schema(description = "短信类型 1 验证码 2 通知")
    private Integer type;

    @Schema(description = "手机号")
    private String phoneNumber;

    @Schema(description = "上限")
    private Integer upperLimit;

    @Schema(description = "发送间隔时间（分钟）")
    private Integer intervalTime;

    @Schema(description = "发送内容")
    private String content;

    @Schema(description = "验证码")
    private Integer captcha;

    @Schema(description = "验证码长度")
    private Integer captchaLength;

    @Schema(description = "验证码有效期 （分钟）")
    private Integer captchaExpiryDate;

    @Schema(description = "是否成功 1.是 0.否")
    private Integer isSuccess;

    @Schema(description = "失败信息")
    private String failMessage;

    @Schema(description = "备注")
    private String remark;

    @Schema(description = "创建人")
    private String createBy;

    @Schema(description = "创建时间")
    private LocalDateTime createDateTime;

    @Schema(description = "最后一次更新人")
    private String lastModifyBy;

    @Schema(description = "最后一次更新时间")
    private LocalDateTime lastModifyDateTime;
}
