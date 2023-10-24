package com.lingyi.mall.api.member.consumer;

import com.lingyi.mall.api.member.feign.LevelFeign;
import com.lingyi.mall.common.core.exception.OpenFeignException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/7/21 9:43
 * @description
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class LevelFeignConsumer {

    private final LevelFeign memberLevelFeign;

    public Long getDefaultLevelId() {
        var response = memberLevelFeign.getDefaultLevelId();
        if (response.getIsSuccess()) {
            log.info("出参:id:{}", response.getData());
            return response.getData();
        }
        throw new OpenFeignException(response.getCode(), response.getMessage());
    }

}
