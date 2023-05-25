package com.lingyi.mall.api.member.fallbackfactory;

import com.lingyi.mall.api.member.feign.MbmMemberFeign;
import org.springframework.cloud.openfeign.FallbackFactory;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/5/25 16:13
 * @description
 */
public class MbmMemberFeignFallbackFactory implements FallbackFactory<MbmMemberFeign> {
    @Override
    public MbmMemberFeign create(Throwable cause) {
        return null;
    }
}
