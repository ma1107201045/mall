package com.lingyi.mall.api.member.consumer;

import com.alibaba.fastjson2.JSON;
import com.lingyi.mall.api.member.reqeust.MemberRequest;
import com.lingyi.mall.api.member.response.MemberResponse;
import com.lingyi.mall.api.member.feign.MemberFeign;
import com.lingyi.mall.common.core.exception.OpenFeignException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/6/6 9:05
 * @description
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class MemberFeignConsumer {

    private final MemberFeign memberFeign;

    public Long register(MemberRequest memberRequest) {
        log.info("入参:memberReqDTO:{}", JSON.toJSONString(memberRequest));
        var response = memberFeign.register(memberRequest);
        if (response.getIsSuccess()) {
            log.info("出参:id:{}", JSON.toJSONString(response.getData()));
            return response.getData();
        }
        throw new OpenFeignException(response.getCode(), response.getMessage());
    }

    public MemberResponse getByPhoneNumber(String phoneNumber) {
        log.info("入参:phoneNumber:{}", phoneNumber);
        var response = memberFeign.getByPhoneNumber(phoneNumber);
        if (response.getIsSuccess()) {
            log.info("出参:MemberRespDTO:{}", JSON.toJSONString(response.getData()));
            return response.getData();
        }
        throw new OpenFeignException(response.getCode(), response.getMessage());
    }
}

