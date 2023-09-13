package com.lingyi.mall.web.admin.member.controller;

import com.lingyi.mall.biz.member.dto.MemberPartDTO;
import com.lingyi.mall.biz.member.service.MemberService;
import com.lingyi.mall.common.core.enums.OperationTypeEnum;
import com.lingyi.mall.common.core.util.ServerResponse;
import com.lingyi.mall.common.security.common.aspetct.Log;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: maweiyan
 * @Email: 1107201045@qq.com
 * @DateTime: 2023/9/8 14:38
 * @Description:
 */
@Tag(name = "【会员管理服务-会员】", description = "【会员管理服务-会员】")
@RequestMapping("/admin/member/members")
@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @Operation(summary = "更新状态", description = "更新状态")
    @PatchMapping("/{id}")
    @PreAuthorize("@ps.hasAnyAuthority('admin:member:members:updateIsEnable')")
    @Log(title = "更新会员", operationType = OperationTypeEnum.UPDATE)
    public ServerResponse<Void> updateIsEnableById(@PathVariable Long id, @Valid @RequestBody MemberPartDTO memberPartDTO) {
        memberPartDTO.setId(id);
        memberService.updateIsEnableById(memberPartDTO);
        return ServerResponse.success();
    }
}
