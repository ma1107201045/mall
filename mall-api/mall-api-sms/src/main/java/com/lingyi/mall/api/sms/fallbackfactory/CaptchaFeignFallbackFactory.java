package com.lingyi.mall.api.sms.fallbackfactory;

import com.lingyi.mall.api.sms.feign.CaptchaFeign;
import org.springframework.cloud.openfeign.FallbackFactory;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/7/13 16:15
 * @description
 */
public class CaptchaFeignFallbackFactory implements FallbackFactory<CaptchaFeign> {
    @Override
    public CaptchaFeign create(Throwable cause) {
        return null;
    }
}
