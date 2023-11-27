package com.lingyi.mall.api.member.feign;

import com.lingyi.mall.api.member.reqeust.MemberRequest;
import com.lingyi.mall.api.member.response.MemberResponse;
import com.lingyi.mall.api.member.fallbackfactory.MemberFeignFallbackFactory;
import com.lingyi.mall.common.core.util.ServerResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/5/25 16:13
 * @description
 */
@FeignClient(value = "mall-web-app-member", fallbackFactory = MemberFeignFallbackFactory.class)
public interface MemberFeign {

    String URL_PREFIX = "/app/member/members";

    /**
     * 注册
     *
     * @param memberRequest 。。
     * @return Void
     */
    @PostMapping(URL_PREFIX)
    ServerResponse<Long> register(@RequestBody MemberRequest memberRequest);

    /**
     * 按照用户名称查询用户信息和按钮权限标识
     *
     * @param phoneNumber 手机号
     * @return 用户信息
     */
    @GetMapping(URL_PREFIX)
    ServerResponse<MemberResponse> getByPhoneNumber(@RequestParam(name = "phoneNumber") String phoneNumber);


}
