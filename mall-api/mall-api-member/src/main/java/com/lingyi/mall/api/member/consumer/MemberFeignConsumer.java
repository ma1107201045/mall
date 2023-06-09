package com.lingyi.mall.api.member.consumer;

import com.alibaba.fastjson2.JSON;
import com.lingyi.mall.api.member.dto.MemberReqDTO;
import com.lingyi.mall.api.member.feign.MemberFeign;
import com.lingyi.mall.common.util.OpenFeignException;
import com.lingyi.mall.common.util.ServerResponse;
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

    public MemberReqDTO getByPhoneNumber(String phoneNumber) {
        log.info("入参:phoneNumber:{}", phoneNumber);
        ServerResponse<MemberReqDTO> response = memberFeign.getByPhoneNumber(phoneNumber);
        if (response.getIsSuccess()) {
            log.info("出参:MemberVO:{}", JSON.toJSONString(response.getData()));
            return response.getData();
        }
        throw new OpenFeignException(response.getBizCode(), response.getMessage());
    }
}

