package com.lingyi.mall.api.sms.fallbackfactory;

import com.lingyi.mall.api.sms.feign.SmsFeign;
import org.springframework.cloud.openfeign.FallbackFactory;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/7/13 16:15
 * @description
 */
public class SmsFeignFallbackFactory implements FallbackFactory<SmsFeign> {
    @Override
    public SmsFeign create(Throwable cause) {
        return null;
    }
}
