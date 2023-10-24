package com.lingyi.mall.api.info.fallbackfactory;

import com.lingyi.mall.api.info.feign.InfoFeign;
import org.springframework.cloud.openfeign.FallbackFactory;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/7/13 16:15
 * @description
 */
public class InfoFeignFallbackFactory implements FallbackFactory<InfoFeign> {
    @Override
    public InfoFeign create(Throwable cause) {
        return null;
    }
}
