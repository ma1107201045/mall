package com.lingyi.mall.biz.system.controller.background;

import com.lingyi.mall.api.system.entity.User;
import com.lingyi.mall.biz.system.service.MbsUserService;
import com.lingyi.mall.common.bean.dto.BaseBackgroundPageDTO;
import com.lingyi.mall.common.util.ServerResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: maweiyan
 * @Email 1107201045@qq.com
 * @DateTime: 2023/5/3 19:10
 * @Description:
 */
@Tag(name = "后台【系统管理服务-用户】", description = "后台【系统管理服务-用户】")
@RequiredArgsConstructor
@Validated
@RequestMapping("/mbs/users")
@RestController
public class MbsUserController {

    private final MbsUserService mbsUserService;

    @Operation(summary = "保存", description = "保存")
    @PostMapping
    public ServerResponse<Void> save(@Valid @RequestBody User user) {
        mbsUserService.add(user);
        return ServerResponse.success();
    }

    @Operation(summary = "删除", description = "删除")
    @DeleteMapping("/{ids}")
    public ServerResponse<Void> removeByIds(@PathVariable Iterable<Long> ids) {
        mbsUserService.removeByIds(ids);
        return ServerResponse.success();
    }

    @Operation(summary = "更新", description = "更新")
    @PutMapping("/{id}")
    public ServerResponse<Void> updateById(@PathVariable Long id, @Valid @RequestBody User user) {
        user.setId(id);
        mbsUserService.editById(user);
        return ServerResponse.success();
    }

    @Operation(summary = "查询", description = "查询")
    @GetMapping("/{id}")
    public ServerResponse<User> getById(@PathVariable Long id) {
        User mbsUser = mbsUserService.findById(id);
        return ServerResponse.success(mbsUser);
    }

    @Operation(summary = "查询列表", description = "查询列表")
    @GetMapping
    public ServerResponse<List<User>> getListByPageAndCondition(@Valid BaseBackgroundPageDTO dto, @Valid User user) {
        List<User> users = mbsUserService.findListByPageAndCondition(dto, user);
        return ServerResponse.success(users);
    }

}
