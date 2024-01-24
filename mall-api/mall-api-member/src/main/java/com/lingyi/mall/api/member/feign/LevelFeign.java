package com.lingyi.mall.api.member.feign;

import com.lingyi.mall.api.member.fallbackfactory.LevelFeignFallbackFactory;
import com.lingyi.mall.common.web.util.ServerResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/7/21 9:24
 * @description
 */
@Tag(name = "会员等级", description = "会员等级")
@FeignClient(value = "mall-web-app-member", fallbackFactory = LevelFeignFallbackFactory.class)
public interface LevelFeign {

    String URL_PREFIX = "/app/member/levels";

    /**
     * 获取默认等级id
     *
     * @return 等级id
     */
    @Operation(description = "获取默认等级id")
    @GetMapping(URL_PREFIX)
    ServerResponse<Long> getDefaultLevelId();
}
