package com.lingyi.mall.api.member.feign;

import com.lingyi.mall.api.member.fallbackfactory.LevelFeignFallbackFactory;
import com.lingyi.mall.common.core.util.ServerResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/7/21 9:24
 * @description
 */
@FeignClient(value = "mall-web-app-member", fallbackFactory = LevelFeignFallbackFactory.class)
public interface MemberLevelFeign {

    String URL_PREFIX = "/app/member/member-levels";

    /**
     * 获取默认等级
     *
     * @return 会员信息
     */
    @GetMapping(URL_PREFIX)
    ServerResponse<Long> getDefaultLevelId();
}
