package com.lingyi.mall.api.member.feign;

import com.lingyi.mall.api.member.dto.MemberLoginLogReqDTO;
import com.lingyi.mall.common.base.util.ServerResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/8/17 9:35
 * @description
 */
public interface MemberLoginLogFeign {
    String URL_PREFIX = "/app/member/member-login-logs";

    /**
     * 获取默认等级
     *
     * @return 会员信息
     */
    @PostMapping(URL_PREFIX)
    ServerResponse<Void> save(@RequestBody MemberLoginLogReqDTO memberLoginLogReqDTO);
}
