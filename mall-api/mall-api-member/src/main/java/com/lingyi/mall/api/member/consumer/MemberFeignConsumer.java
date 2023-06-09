package com.lingyi.mall.api.member.consumer;

import com.alibaba.fastjson2.JSON;
import com.lingyi.mall.api.member.dto.MemberDTO;
import com.lingyi.mall.api.member.feign.MemberFeign;
import com.lingyi.mall.api.member.vo.MemberVO;
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

    public MemberDTO getByPhoneNumber(String phoneNumber) {
        log.info("入参:phoneNumber:{}", phoneNumber);
        ServerResponse<MemberDTO> response = memberFeign.getByPhoneNumber(phoneNumber);
        if (response.getIsSuccess()) {
            log.info("出参:MemberVO:{}", JSON.toJSONString(response.getData()));
            return response.getData();
        }
        throw new OpenFeignException(response.getBizCode(), response.getMessage());
    }
}

