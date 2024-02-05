package com.lingyi.mall.biz.system.service.impl;

import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollUtil;
import cn.hutool.crypto.SecureUtil;
import com.lingyi.mall.api.system.response.MenuResponse;
import com.lingyi.mall.api.system.request.UserPartRequest;
import com.lingyi.mall.api.system.response.UserResponse;
import com.lingyi.mall.biz.system.constant.SystemConstant;
import com.lingyi.mall.biz.system.converter.UserConverter;
import com.lingyi.mall.biz.system.dao.mapper.UserMapper;
import com.lingyi.mall.biz.system.dao.repository.UserRepository;
import com.lingyi.mall.biz.system.enums.MenuTypeEnum;
import com.lingyi.mall.biz.system.enums.SystemFailEnum;
import com.lingyi.mall.biz.system.model.dto.UserDTO;
import com.lingyi.mall.biz.system.model.entity.UserDO;
import com.lingyi.mall.biz.system.model.query.RoleQuery;
import com.lingyi.mall.biz.system.model.query.UserQuery;
import com.lingyi.mall.biz.system.model.vo.RoleVO;
import com.lingyi.mall.biz.system.model.vo.UserVO;
import com.lingyi.mall.biz.system.service.MenuService;
import com.lingyi.mall.biz.system.service.RoleService;
import com.lingyi.mall.biz.system.service.UserRoleService;
import com.lingyi.mall.biz.system.service.UserService;
import com.lingyi.mall.biz.system.util.OperationTypeEnum;
import com.lingyi.mall.common.core.enums.WhetherEnum;
import com.lingyi.mall.common.core.util.AssertUtil;
import com.lingyi.mall.common.core.util.ConverterUtil;
import com.lingyi.mall.common.core.util.ObjectUtil;
import com.lingyi.mall.common.core.util.TreeUtil;
import com.lingyi.mall.common.orm.util.BaseServiceProImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author: maweiyan
 * @Email 1107201045@qq.com
 * @DateTime: 2023/5/3 20:04
 * @Description:
 */
@Service
@RequiredArgsConstructor
public class UserServiceImpl extends BaseServiceProImpl<UserRepository, UserMapper, UserDTO, UserVO, UserQuery, UserDO, Long>
        implements UserService {

    private final UserRoleService userRoleService;

    private final RoleService roleService;

    private final MenuService menuService;

    private final com.lingyi.mall.biz.system.converter.mapper.UserMapper userMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void create(UserDTO userDTO) {
        //校验数据
        verifyData(userDTO, ObjectUtil.getNull(), OperationTypeEnum.CREATE);
        //密码作哈希
        userDTO.setPassword(SecureUtil.md5(userDTO.getPassword()));
        //保存
        var id = create(userDTO, UserDO.class);
        //保存用户角色信息
        userRoleService.createList(id, userDTO.getRoleIds());
        //校验账号是否禁用，如果满足先踢下线+封禁账号
        kickoutAndDisable(userDTO, id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteByIds(List<Long> ids) {
        if (CollUtil.isEmpty(ids)) {
            return;
        }
        //校验数据
        verifyData(ObjectUtil.getNull(), ids, OperationTypeEnum.DELETE);
        //删除用户集
        super.deleteByIds(ids);
        //删除用户角色
        userRoleService.deleteByUserIds(ids);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateByDTO(UserDTO userDTO) {
        //校验数据
        verifyData(userDTO, ObjectUtil.getNull(), OperationTypeEnum.UPDATE);
        //密码作哈希
        userDTO.setPassword(SecureUtil.md5(userDTO.getPassword()));
        //更新
        Long id = updateById(userDTO);
        //删除用户角色集
        userRoleService.deleteByUserIds(Collections.singletonList(id));
        //保存用户角色信息
        userRoleService.createList(id, userDTO.getRoleIds());
        //校验账号是否禁用，如果满足先踢下线+封禁账号
        kickoutAndDisable(userDTO, id);
    }

    @Override
    public List<RoleVO> readRoleList(RoleQuery roleQuery) {
        return roleService.readListByParam(roleQuery);
    }

    @Override
    public void updatePartById(UserPartRequest userPartRequest) {
        //校验是否可以更新
        AssertUtil.notEquals(SystemConstant.USER_ID_ADMIN, userPartRequest.getId(), SystemFailEnum.USER_NAME_ADMIN_UPDATE_ERROR);
        // 密码作哈希
        userPartRequest.setPassword(SecureUtil.md5(userPartRequest.getPassword()));
        //  更新数据
        var userDO = userMapper.toUserDO(userPartRequest);
        //更新
        updateById(userDO);
    }


    @Override
    public UserResponse readUserByUserName(String userName) {
        return mybatisMapper.selectByUserName(userName);
    }

    @Override
    public List<MenuResponse> readMenuTreesById(Long id) {
        List<MenuResponse> menus;
        var menuTypes = CollUtil.newArrayList(MenuTypeEnum.DIRECTORY.getCode(), MenuTypeEnum.MENU.getCode());
        if (!SystemConstant.USER_ID_ADMIN.equals(id)) {
            menus = mybatisMapper.selectMenusByIdAndMenuTypes(id, menuTypes);
        } else {
            menus = menuService.readListByTypes(menuTypes);
        }
        return TreeUtil.buildOfMap(menus);
    }

    @Override
    public List<String> readMenuPermissionsById(Long id) {
        var userVO = readById(id);
        AssertUtil.notNull(userVO, SystemFailEnum.USER_NULL_ERROR);
        List<MenuResponse> menus;
        var menuTypes = Collections.singletonList(MenuTypeEnum.BUTTON.getCode());
        if (!SystemConstant.USER_ID_ADMIN.equals(id)) {
            menus = mybatisMapper.selectMenusByIdAndMenuTypes(id, menuTypes);
        } else {
            menus = menuService.readListByTypes(menuTypes);
        }
        return menus.stream().map(MenuResponse::getPermission).toList();
    }


    private void verifyData(UserDTO userDTO, List<Long> ids, OperationTypeEnum operationTypeEnum) {
        if (operationTypeEnum == OperationTypeEnum.CREATE) {
            //断言用户是否admin
            AssertUtil.isFalse(SystemConstant.USER_NAME_ADMIN.equals(userDTO.getUserName()),
                    SystemFailEnum.USER_NAME_ADMIN_CREATE_ERROR);
            //通过用户名称获取用户id
            var id = jpaRepository.findIdByUserName(userDTO.getUserName());
            //判断用户名称不存在
            AssertUtil.isNull(id, SystemFailEnum.USER_NAME_EXIST_ERROR);
            return;
        }
        if (operationTypeEnum == OperationTypeEnum.UPDATE) {
            //断言用户是否admin
            AssertUtil.isFalse(SystemConstant.USER_NAME_ADMIN.equals(userDTO.getUserName()),
                    SystemFailEnum.USER_NAME_ADMIN_UPDATE_ERROR);
            //断言用户名称是否相同
            var id = jpaRepository.findIdByUserName(userDTO.getUserName());
            var flag = Objects.nonNull(id) && !Objects.equals(userDTO.getId(), id);
            AssertUtil.isTrue(flag, SystemFailEnum.USER_NAME_EXIST_ERROR);
            return;
        }
        if (operationTypeEnum == OperationTypeEnum.DELETE) {
            var flag = jpaRepository.findAllById(ids).stream()
                    .anyMatch(userDO -> SystemConstant.USER_NAME_ADMIN.equals(userDO.getUserName()));
            AssertUtil.isFalse(flag, SystemFailEnum.USER_NAME_ADMIN_DELETE_ERROR);
        }
    }

    private void kickoutAndDisable(UserDTO userDTO, Long id) {
        if (WhetherEnum.Y.getCode().equals(userDTO.getIsDisable())) {
            if (StpUtil.isLogin(id)) {
                StpUtil.kickout(id);
            }
            StpUtil.disable(id, SystemConstant.USER_DISABLE_TIME);
        }
    }


}
