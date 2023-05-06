package com.lingyi.mall.biz.system.controller.background;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lingyi.mall.api.system.entity.MbsUser;
import com.lingyi.mall.api.system.enums.MbsMenuType;
import com.lingyi.mall.api.system.vo.MbsUserVO;
import com.lingyi.mall.biz.system.service.MbsUserService;
import com.lingyi.mall.common.util.BaseController;
import com.lingyi.mall.common.util.PageParam;
import com.lingyi.mall.common.util.ServerResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: maweiyan
 * @Email 1107201045@qq.com
 * @DateTime: 2023/5/3 19:10
 * @Description:
 */
@Tag(name = "系统管理-用户", description = "系统管理-用户")
@RequiredArgsConstructor
@Validated
@RequestMapping("/mbs/users")
@RestController
public class MbsUserController implements BaseController<MbsUser, Long> {

    private final MbsUserService mbsUserService;

    @Operation(summary = "保存", description = "保存用户")
    @PostMapping
    public ServerResponse<Void> save(@RequestBody MbsUser mbsUser) {
        mbsUserService.add(mbsUser);
        return ServerResponse.success();
    }

    @Operation(summary = "删除/批量删除", description = "删除/批量删除用户")
    @Parameter(description = "主键id集", in = ParameterIn.PATH)
    @DeleteMapping("/{ids}")
    public ServerResponse<Void> removeByIds(@PathVariable Iterable<Long> ids) {
        mbsUserService.removeByIds(ids);
        return ServerResponse.success();
    }

    @Operation(summary = "更新", description = "更新用户")
    @Parameter(name = "主键id", in = ParameterIn.PATH, description = "id")
    @PutMapping("/{id}")
    public ServerResponse<Void> updateById(@PathVariable Long id, @RequestBody MbsUser mbsUser) {
        mbsUser.setId(id);
        mbsUserService.editById(mbsUser);
        return ServerResponse.success();
    }

    @Operation(summary = "查询单条", description = "查询单条用户")
    @Parameter(name = "主键id", in = ParameterIn.PATH, description = "id")
    @GetMapping("/{id}")
    public ServerResponse<MbsUser> getById(@PathVariable Long id) {
        MbsUser mbsUser = mbsUserService.findById(id);
        return ServerResponse.success(mbsUser);
    }

    @Operation(summary = "查询多条", description = "查询多条用户")
    @GetMapping
    public ServerResponse<IPage<MbsUser>> getListPageAndCondition(PageParam pageParam, MbsUser mbsUser) {
        IPage<MbsUser> ipage = mbsUserService.findListPageAndCondition(new Page<>(pageParam.getCurrentPage(), pageParam.getPageSize()), mbsUser);
        return ServerResponse.success(ipage);
    }


    @Operation(summary = "查询用户信息[provider]", description = "按照用户名称查询[provider]")
    @Parameter(description = "用户名称", required = true, example = "zhangsan")
    @GetMapping("/provider")
    public ServerResponse<MbsUserVO> getByUserName(String userName) {
        MbsUserVO mbsUserVO = mbsUserService.findOneByUserNameAndMenuType(userName, MbsMenuType.BUTTON);
        return ServerResponse.success(mbsUserVO);
    }
}
