package com.lingyi.mall.api.sms.fallbackfactory;

import com.lingyi.mall.api.sms.feign.SmsFeign;
import org.springframework.cloud.openfeign.FallbackFactory;

/**
 * @Author: maweiyan
 * @Email 1107201045@qq.com
 * @DateTime: 2023/10/15 4:09
 * @Description:
 */
public class CapchaFeignFallbackFactory implements FallbackFactory<SmsFeign> {
    @Override
    public SmsFeign create(Throwable cause) {
        return null;
    }
}
