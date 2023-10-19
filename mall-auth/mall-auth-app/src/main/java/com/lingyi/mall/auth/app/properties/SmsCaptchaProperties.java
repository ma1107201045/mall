package com.lingyi.mall.auth.app.properties;

import com.lingyi.mall.api.sms.enums.SmsBusinessEnum;
import com.lingyi.mall.api.sms.enums.SmsServiceEnum;
import com.lingyi.mall.api.sms.enums.SmsTypeEnum;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/7/14 10:09
 * @description
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "sms-captcha")
public class SmsCaptchaProperties {
    /**
     * 服务类型
     */
    private SmsServiceEnum service = SmsServiceEnum.UNKNOWN;
    /**
     * 业务类型
     */
    private SmsBusinessEnum business = SmsBusinessEnum.UNKNOWN;

    /**
     * 业务类型
     */
    private SmsTypeEnum type = SmsTypeEnum.UNKNOWN;
    /**
     * 每天上限
     */
    public Integer upperLimit = 10;

    /**
     * 间隔时间(分钟)
     */
    public Integer intervalTime = 1;
    /**
     * 验证码长度
     */
    public Integer captchaLength = 6;
    /**
     * 验证码失效时间
     */
    public Integer captchaExpiryDate = 30;

}
