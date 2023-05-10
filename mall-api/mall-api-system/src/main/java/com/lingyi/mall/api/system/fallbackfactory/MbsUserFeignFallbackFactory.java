package com.lingyi.mall.api.system.fallbackfactory;

import com.lingyi.mall.api.system.feign.MbsUserFeign;
import org.springframework.cloud.openfeign.FallbackFactory;

/**
 * @Author: maweiyan
 * @Email 1107201045@qq.com
 * @DateTime: 2023/5/3 20:34
 * @Description:
 */
public class MbsUserFeignFallbackFactory implements FallbackFactory<MbsUserFeign> {

    @Override
    public MbsUserFeign create(Throwable cause) {
        return userName -> null;
    }
}
