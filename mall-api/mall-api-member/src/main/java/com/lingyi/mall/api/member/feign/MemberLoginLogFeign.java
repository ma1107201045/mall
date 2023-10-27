package com.lingyi.mall.api.member.feign;

import com.lingyi.mall.api.member.dto.MemberLoginLogReqDTO;
import com.lingyi.mall.api.member.fallbackfactory.MemberLoginLogFeignFallbackFactory;
import com.lingyi.mall.common.core.util.ServerResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/8/17 9:35
 * @description
 */
@FeignClient(value = "mall-web-app-member", fallbackFactory = MemberLoginLogFeignFallbackFactory.class)
public interface MemberLoginLogFeign {
    String URL_PREFIX = "/app/member/login-logs";

    /**
     * 获取默认等级
     *
     * @return 会员信息
     */
    @PostMapping(URL_PREFIX)
    ServerResponse<Void> save(@RequestBody MemberLoginLogReqDTO memberLoginLogReqDTO);
}
