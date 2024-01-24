package com.lingyi.mall.web.admin.member.controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.annotation.SaCheckPermission;
import com.github.pagehelper.PageHelper;
import com.lingyi.mall.biz.member.model.dto.MemberPartDTO;
import com.lingyi.mall.biz.member.model.query.MemberQuery;
import com.lingyi.mall.biz.member.model.vo.MemberVO;
import com.lingyi.mall.biz.member.service.MemberService;
import com.lingyi.mall.common.web.util.ServerResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springdoc.core.annotations.ParameterObject;
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
@SaCheckLogin
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @Operation(summary = "更新状态", description = "更新状态")
    @PatchMapping("/{id}")
    @SaCheckPermission("admin:member:members:updateIsEnable")
    public ServerResponse<Void> updateIsEnableById(@PathVariable Long id, @Valid @RequestBody MemberPartDTO memberPartDTO) {
        memberPartDTO.setId(id);
        memberService.updateIsEnableById(memberPartDTO);
        return ServerResponse.success();
    }

    @Operation(summary = "查询列表", description = "查询列表")
    @GetMapping
    @SaCheckPermission("admin:member:members:getList")
    public ServerResponse<List<MemberVO>> getList(@ParameterObject @Valid MemberQuery memberParam) {
        var page = PageHelper.startPage(memberParam.getCurrentPage(), memberParam.getPageSize(), memberParam.getSort());
        var members = memberService.readListByParam(memberParam);
        return ServerResponse.success(members, page.getTotal());
    }
}
