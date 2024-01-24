package com.lingyi.mall.web.app.member.provider;

import com.lingyi.mall.api.member.feign.LevelFeign;
import com.lingyi.mall.biz.member.service.LevelService;
import com.lingyi.mall.common.web.util.ServerResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/7/21 9:29
 * @description
 */

@RestController
@RequiredArgsConstructor
public class LevelFeignProvider implements LevelFeign {

    private final LevelService levelService;

    @Override
    public ServerResponse<Long> getDefaultLevelId() {
        Long id = levelService.queryDefaultLevelId();
        return ServerResponse.success(id);
    }
}
