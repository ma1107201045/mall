package com.lingyi.mall.auth.app.properties;

import com.lingyi.mall.api.sms.enums.BusinessTypeEnum;
import com.lingyi.mall.api.sms.enums.ServiceTypeEnum;
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
    private ServiceTypeEnum serviceTypeEnum = ServiceTypeEnum.UNKNOWN;
    /**
     * 业务类型
     */
    private BusinessTypeEnum businessTypeEnum = BusinessTypeEnum.UNKNOWN;
    /**
     * 验证码长度
     */
    public Integer length = 6;
    /**
     * 验证码失效时间
     */
    public Integer expiryDate = 30;
    /**
     * 验证码发送间隔时间(分钟)
     */
    public Integer intervalDate = 1;
    /**
     * 验证码每天上限
     */
    public Integer upperLimit = 10;
}
