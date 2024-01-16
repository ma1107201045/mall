package com.lingyi.mall.api.member.fallbackfactory;

import com.lingyi.mall.api.member.feign.MemberFeign;
import com.lingyi.mall.api.member.reqeust.MemberRequest;
import com.lingyi.mall.api.member.response.MemberResponse;
import com.lingyi.mall.common.web.util.ServerResponse;
import org.springframework.cloud.openfeign.FallbackFactory;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/5/25 16:13
 * @description
 */
public class MemberFeignFallbackFactory implements FallbackFactory<MemberFeign> {
    @Override
    public MemberFeign create(Throwable cause) {
        return new MemberFeign() {
            @Override
            public ServerResponse<Long> register(MemberRequest memberRequest) {
                return null;
            }

            @Override
            public ServerResponse<MemberResponse> getByPhoneNumber(String phoneNumber) {
                return null;
            }
        };
    }
}
