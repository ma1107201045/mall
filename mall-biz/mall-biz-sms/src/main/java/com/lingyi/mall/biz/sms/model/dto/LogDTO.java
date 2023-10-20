package com.lingyi.mall.biz.sms.model.dto;

import com.lingyi.mall.common.core.dto.BaseIdDTO;
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
public class LogDTO extends BaseIdDTO<Long> {

    @Serial
    private static final long serialVersionUID = -8254294466774665611L;

    /**
     * 服务名称
     */
    private String serviceName;

    /**
     * 业务名称
     */
    private String businessName;

    /**
     * 短信类型 1.通知 2.短信
     */
    private Integer type;

    /**
     * 手机号
     */
    private String phoneNumber;

    /**
     * 每天发送上限
     */
    private Integer upperLimit;

    /**
     * 发送间隔时间（分钟）
     */
    private Integer intervalTime;

    /**
     * 发送内容
     */
    private String content;

    /**
     * 验证码
     */
    private Integer captcha;

    /**
     * 验证码长度
     */
    private Integer captchaLength;

    /**
     * 验证码有效期 （分钟）
     */
    private Integer captchaExpiryDate;

    /**
     * 是否发送成功 1.是 0.否
     */
    private Integer isSuccess;

    /**
     * 失败信息
     */
    private String failMessage;

    /**
     * 备注
     */
    private String remark;
}
