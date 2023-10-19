package com.lingyi.mall.common.xxljob.properties;

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

    /**
     * admin地址### xxl-job admin address list, such as "http://address" or "http://address01,http://address02"
     */
    private String adminAddresses;

    /**
     * 访问token
     */
    private String accessToken;

    /**
     * app名称
     */
    private String appName;
    /**
     * ### xxl-job executor registry-address: default use address to registry , otherwise use ip:port if address is null
     */
    private String address;
    /**
     * ### xxl-job executor server-info
     */
    private String ip;


    private int port;

    /**
     * 日志路径
     */
    private String logPath;
    /**
     * 日志路径
     */
    private int logRetentionDays;
}
