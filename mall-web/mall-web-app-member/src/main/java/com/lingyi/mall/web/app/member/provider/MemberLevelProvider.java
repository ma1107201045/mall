package com.lingyi.mall.web.app.member.provider;

import com.lingyi.mall.api.member.feign.MemberLevelFeign;
import com.lingyi.mall.biz.member.service.MemberLevelService;
import com.lingyi.mall.common.base.util.ServerResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/7/21 9:29
 * @description
 */
@Tag(name = "前台【会员服务-会员等级-Provider】", description = "前台【会员服务-会员等级-Provider】")
@RequiredArgsConstructor
@RestController
public class MemberLevelProvider implements MemberLevelFeign {

    private final MemberLevelService memberLevelService;

    @Override
    public ServerResponse<Long> getDefaultLevelId() {
        Long id = memberLevelService.readDefaultLevelId();
        return ServerResponse.success(id);
    }
}
