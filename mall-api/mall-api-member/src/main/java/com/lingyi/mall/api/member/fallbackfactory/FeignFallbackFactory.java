package com.lingyi.mall.api.member.fallbackfactory;

import com.lingyi.mall.api.member.dto.MemberReqDTO;
import com.lingyi.mall.api.member.dto.MemberRespDTO;
import com.lingyi.mall.api.member.feign.MemberFeign;
import com.lingyi.mall.common.core.util.ServerResponse;
import org.springframework.cloud.openfeign.FallbackFactory;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/5/25 16:13
 * @description
 */
public class FeignFallbackFactory implements FallbackFactory<MemberFeign> {
    @Override
    public MemberFeign create(Throwable cause) {
        return new MemberFeign() {
            @Override
            public ServerResponse<Long> register(MemberReqDTO memberReqDTO) {
                return null;
            }

            @Override
            public ServerResponse<MemberRespDTO> getByPhoneNumber(String phoneNumber) {
                return null;
            }
        };
    }
}
