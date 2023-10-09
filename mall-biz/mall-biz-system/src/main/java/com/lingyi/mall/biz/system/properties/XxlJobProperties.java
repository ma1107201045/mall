package com.lingyi.mall.biz.system.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: maweiyan
 * @Email: 1107201045@qq.com
 * @DateTime: 2023/10/9 10:09
 * @Description:
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "xxl-job")
public class XxlJobProperties {

    private String adminAddresses;

    private String accessToken;

    private String appName;

    private String address;

    private String ip;

    private int port;

    private String logPath;

    private int logRetentionDays;
}
