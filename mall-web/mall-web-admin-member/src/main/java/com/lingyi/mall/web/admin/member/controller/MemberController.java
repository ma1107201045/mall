package com.lingyi.mall.web.admin.member.controller;

import com.github.pagehelper.PageHelper;
import com.lingyi.mall.biz.member.model.dto.MemberPartDTO;
import com.lingyi.mall.biz.member.model.query.MemberQuery;
import com.lingyi.mall.biz.member.service.MemberService;
import com.lingyi.mall.biz.member.model.vo.MemberVO;
import com.lingyi.mall.common.core.enums.OperationTypeEnum;
import com.lingyi.mall.common.core.util.ServerResponse;
import com.lingyi.mall.common.core.annotation.Log;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: maweiyan
 * @Email: 1107201045@qq.com
 * @DateTime: 2023/9/8 14:38
 * @Description:
 */
@Tag(name = "会员接口", description = "会员接口")
@RequestMapping("/members")
@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @Operation(summary = "更新状态", description = "更新状态")
    @PatchMapping("/{id}")
    @PreAuthorize("@ps.hasAnyAuthority('admin:member:members:updateIsEnable')")
    @Log(title = "更新状态", operationType = OperationTypeEnum.UPDATE)
    public ServerResponse<Void> updateIsEnableById(@PathVariable Long id, @Valid @RequestBody MemberPartDTO memberPartDTO) {
        memberPartDTO.setId(id);
        memberService.updateIsEnableById(memberPartDTO);
        return ServerResponse.success();
    }

    @Operation(summary = "查询列表", description = "查询列表")
    @GetMapping
    @PreAuthorize("@ps.hasAnyAuthority('admin:member:members:getList')")
    @Log(title = "查询会员列表", operationType = OperationTypeEnum.READ)
    public ServerResponse<List<MemberVO>> getList(@Valid MemberQuery memberParam) {
        var page = PageHelper.startPage(memberParam.getCurrentPage(), memberParam.getPageSize(), memberParam.getSort());
        var members = memberService.readListByParam(memberParam);
        return ServerResponse.success(members, page.getTotal());
    }
}
