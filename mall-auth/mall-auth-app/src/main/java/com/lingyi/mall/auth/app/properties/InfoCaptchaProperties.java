package com.lingyi.mall.auth.app.properties;

import com.lingyi.mall.api.info.enums.InfoBusinessEnum;
import com.lingyi.mall.api.info.enums.InfoServiceEnum;
import com.lingyi.mall.api.info.enums.InfoTypeEnum;
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
@ConfigurationProperties(prefix = "info-captcha")
public class InfoCaptchaProperties {
    /**
     * 服务类型
     */
    private InfoServiceEnum service = InfoServiceEnum.UNKNOWN;
    /**
     * 业务类型
     */
    private InfoBusinessEnum business = InfoBusinessEnum.UNKNOWN;

    /**
     * 信息类型
     */
    private InfoTypeEnum type = InfoTypeEnum.SMS_CAPTCHA;
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
