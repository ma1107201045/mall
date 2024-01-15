package com.lingyi.mall.common.web.config;

import com.lingyi.mall.common.core.filter.TrackIdFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: maweiyan
 * @Email: 1107201045@qq.com
 * @DateTime: 2023/9/15 17:36
 * @Description:
 */
@Configuration(proxyBeanMethods = false)
public class TrackIdConfig {

    @Bean
    public TrackIdFilter trackIdFilter() {
        return new TrackIdFilter();
    }
}
