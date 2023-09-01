package com.lingyi.mall.api.member.consumer;

import com.alibaba.fastjson2.JSON;
import com.lingyi.mall.api.member.dto.MemberReqDTO;
import com.lingyi.mall.api.member.dto.MemberRespDTO;
import com.lingyi.mall.api.member.feign.MemberFeign;
import com.lingyi.mall.common.base.exception.OpenFeignException;
import com.lingyi.mall.common.base.util.ServerResponse;
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

    public Long register(MemberReqDTO memberReqDTO) {
        log.info("入参:memberReqDTO:{}", JSON.toJSONString(memberReqDTO));
        var response = memberFeign.register(memberReqDTO);
        if (response.getIsSuccess()) {
            log.info("出参:id:{}", JSON.toJSONString(response.getData()));
            return response.getData();
        }
        throw new OpenFeignException(response.getCode(), response.getMessage());
    }

    public MemberRespDTO getByPhoneNumber(String phoneNumber) {
        log.info("入参:phoneNumber:{}", phoneNumber);
        var response = memberFeign.getByPhoneNumber(phoneNumber);
        if (response.getIsSuccess()) {
            log.info("出参:MemberRespDTO:{}", JSON.toJSONString(response.getData()));
            return response.getData();
        }
        throw new OpenFeignException(response.getCode(), response.getMessage());
    }
}

