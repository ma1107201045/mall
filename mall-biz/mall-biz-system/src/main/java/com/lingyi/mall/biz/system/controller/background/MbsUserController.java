package com.lingyi.mall.biz.system.controller.background;

import com.lingyi.mall.api.system.entity.User;
import com.lingyi.mall.api.system.enums.MbsMenuType;
import com.lingyi.mall.api.system.vo.UserVO;
import com.lingyi.mall.biz.system.service.MbsUserService;
import com.lingyi.mall.common.util.PageParam;
import com.lingyi.mall.common.util.ServerResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
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
@Tag(name = "系统管理-用户", description = "系统管理-用户")
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
    public ServerResponse<List<User>> getListByPageAndCondition(@Valid PageParam pageParam, @Valid User user) {
        List<User> users = mbsUserService.findListByPageAndCondition(pageParam, user);
        return ServerResponse.success(users);
    }


    @Operation(summary = "查询用户和权限[provider]", description = "按照用户名称查询用户和权限")
    @GetMapping("/provider/menus")
    public ServerResponse<UserVO> getUserAndMenuByUserName(@NotBlank(message = "用户名称不能为空") String userName) {
        UserVO userVO = mbsUserService.findUserAndMenuByUserNameAndMenuType(userName, MbsMenuType.BUTTON);
        return ServerResponse.success(userVO);
    }
}
