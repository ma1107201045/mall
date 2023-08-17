package com.lingyi.mall.api.member.fallbackfactory;

import com.alibaba.fastjson2.JSON;
import com.lingyi.mall.api.member.dto.MemberLoginLogReqDTO;
import com.lingyi.mall.api.member.feign.MemberLevelFeign;
import com.lingyi.mall.api.member.feign.MemberLoginLogFeign;
import com.lingyi.mall.common.base.exception.OpenFeignException;
import com.lingyi.mall.common.base.util.ServerResponse;
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
public class MemberLoginLogFeignFallbackFactory implements FallbackFactory<MemberLoginLogFeign> {


    @Override
    public MemberLoginLogFeign create(Throwable cause) {
        return memberLoginLogReqDTO -> null;
    }
}
