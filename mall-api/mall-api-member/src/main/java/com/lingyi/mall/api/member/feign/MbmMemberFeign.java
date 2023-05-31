package com.lingyi.mall.api.member.feign;

import com.lingyi.mall.api.member.fallbackfactory.MbmMemberFeignFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/5/25 16:13
 * @description
 */
//@FeignClient(url = "http://localhost:9002", value = "mall-web-member-app", fallbackFactory = MbmMemberFeignFallbackFactory.class)
public interface MbmMemberFeign {
}
