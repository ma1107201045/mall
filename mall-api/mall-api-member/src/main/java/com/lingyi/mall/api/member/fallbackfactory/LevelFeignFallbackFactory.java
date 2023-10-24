package com.lingyi.mall.api.member.fallbackfactory;

import com.lingyi.mall.api.member.feign.MemberLevelFeign;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Service;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/8/17 15：39
 * @description
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class LevelFeignFallbackFactory implements FallbackFactory<MemberLevelFeign> {

    @Override
    public MemberLevelFeign create(Throwable cause) {
        return () -> null;
    }
}
