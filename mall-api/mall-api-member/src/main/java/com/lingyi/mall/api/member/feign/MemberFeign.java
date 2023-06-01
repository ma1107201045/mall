package com.lingyi.mall.api.member.feign;

import com.lingyi.mall.api.member.fallbackfactory.MemberFeignFallbackFactory;
import com.lingyi.mall.api.member.vo.MemberVO;
import com.lingyi.mall.common.base.util.ServerResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/5/25 16:13
 * @description
 */
@FeignClient(url = "http://localhost:8002", value = "mall-web-member-app", fallbackFactory = MemberFeignFallbackFactory.class)
public interface MemberFeign {


    /**
     * 按照用户名称查询用户信息和按钮权限标识
     *
     * @param phoneNumber 手机号
     * @return 用户信息
     */
    @GetMapping("/member/app/provider/members")
    ServerResponse<MemberVO> getByPhoneNumber(@RequestParam(name = "phoneNumber") String phoneNumber);
}
