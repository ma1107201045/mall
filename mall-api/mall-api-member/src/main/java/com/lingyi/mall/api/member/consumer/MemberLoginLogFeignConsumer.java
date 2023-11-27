package com.lingyi.mall.api.member.consumer;

import com.alibaba.fastjson2.JSON;
import com.lingyi.mall.api.member.reqeust.MemberLoginLogRequest;
import com.lingyi.mall.api.member.feign.MemberLoginLogFeign;
import com.lingyi.mall.common.core.exception.OpenFeignException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/8/17 14:54
 * @description
 */

@Slf4j
@Service
@RequiredArgsConstructor
public class MemberLoginLogFeignConsumer {

    private final MemberLoginLogFeign memberLoginLogFeign;

    public void save(MemberLoginLogRequest memberLoginLogRequest) {
        log.info("入参:memberLoginLogReqDTO:{}", JSON.toJSONString(memberLoginLogRequest));
        var response = memberLoginLogFeign.save(memberLoginLogRequest);
        if (response.getIsSuccess()) {
            log.info("出参:void:{}", JSON.toJSONString(response.getData()));
            return;
        }
        throw new OpenFeignException(response.getCode(), response.getMessage());
    }
}
