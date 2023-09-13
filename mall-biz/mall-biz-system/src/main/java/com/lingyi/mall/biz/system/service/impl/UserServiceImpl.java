package com.lingyi.mall.biz.system.service.impl;

import com.lingyi.mall.api.system.dto.MenuRespDTO;
import com.lingyi.mall.api.system.dto.UserPartReqDTO;
import com.lingyi.mall.api.system.dto.UserRespDTO;
import com.lingyi.mall.biz.system.constant.SystemConstant;
import com.lingyi.mall.biz.system.converter.UserConverter;
import com.lingyi.mall.biz.system.dto.UserDTO;
import com.lingyi.mall.biz.system.entity.UserDO;
import com.lingyi.mall.biz.system.enums.MenuTypeEnum;
import com.lingyi.mall.biz.system.enums.SystemFailEnum;
import com.lingyi.mall.biz.system.mapper.UserMapper;
import com.lingyi.mall.biz.system.param.UserParam;
import com.lingyi.mall.biz.system.repository.UserRepository;
import com.lingyi.mall.biz.system.service.MenuService;
import com.lingyi.mall.biz.system.service.RoleService;
import com.lingyi.mall.biz.system.service.UserRoleService;
import com.lingyi.mall.biz.system.service.UserService;
import com.lingyi.mall.biz.system.vo.RoleVO;
import com.lingyi.mall.biz.system.vo.UserVO;
import com.lingyi.mall.common.orm.param.BasePageParam;
import com.lingyi.mall.common.core.util.AssertUtil;
import com.lingyi.mall.common.core.util.ConverterUtil;
import com.lingyi.mall.common.core.util.ObjectUtil;
import com.lingyi.mall.common.orm.util.BaseServiceProImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * @Author: maweiyan
 * @Email 1107201045@qq.com
 * @DateTime: 2023/5/3 20:04
 * @Description:
 */
@Service
@RequiredArgsConstructor
public class UserServiceImpl extends BaseServiceProImpl<UserRepository, UserMapper, UserDTO, UserVO, UserParam, UserDO, Long> implements UserService {

    private final PasswordEncoder passwordEncoder;

    private final UserRoleService userRoleService;

    private final RoleService roleService;

    private final MenuService menuService;


    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(UserDTO userDTO) {
        //通过用户名称获取用户id
        var id = mybatisMapper.selectIdByUserName(userDTO.getUserName());
        //判断用户名称不存在
        AssertUtil.isNull(id, SystemFailEnum.USER_NAME_EXIST_ERROR);
        //密码作哈希
        var encodePassword = passwordEncoder.encode(userDTO.getPassword());
        userDTO.setPassword(encodePassword);
        //保存
        create(userDTO, UserDO.class);
        //保存用户角色信息
        userRoleService.createList(userDTO.getId(), userDTO.getRoleIds());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteByIds(List<Long> ids) {
        var flag = jpaRepository.findAllById(ids).stream()
                .anyMatch(userDO -> SystemConstant.USER_NAME_ADMIN.equals(userDO.getUserName()));
        AssertUtil.isFalse(flag, SystemFailEnum.USER_NAME_ADMIN_DELETE_ERROR);
        jpaRepository.deleteAllById(ids);
        userRoleService.deleteByUserIds(ids);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateById(UserDTO userDTO) {
        var id = userDTO.getId();
        //获取用户信息
        var optional = jpaRepository.findById(id);
        //断言用户是否不为空
        AssertUtil.isFalse(optional.isEmpty(), SystemFailEnum.USER_NULL_ERROR);
        //获取用户
        var userDO = optional.get();
        //断言用户是否admin
        AssertUtil.isFalse(SystemConstant.USER_NAME_ADMIN.equals(userDO.getUserName()), SystemFailEnum.USER_NAME_ADMIN_UPDATE_ERROR);

        //断言用户名称是否相同
        var newId = mybatisMapper.selectIdByUserName(userDTO.getUserName());
        var flag = Objects.nonNull(newId) && !Objects.equals(id, newId);
        AssertUtil.isFalse(flag, SystemFailEnum.USER_NAME_EXIST_ERROR);

        //密码作哈希
        var encodePassword = passwordEncoder.encode(userDTO.getPassword());
        userDTO.setPassword(encodePassword);

        super.updateById(userDTO);
        //删除用户角色集
        userRoleService.deleteByUserIds(Collections.singletonList(id));
        //保存用户角色信息
        userRoleService.createList(id, userDTO.getRoleIds());
    }

    @Override
    public List<RoleVO> readRoleList(BasePageParam basePageParam) {
        return roleService.readList(basePageParam);
    }

    @Override
    public void updatePartById(UserPartReqDTO userPartReqDTO) {
        //获取用户信息
        var optional = jpaRepository.findById(userPartReqDTO.getId());
        //断言用户是否不为空
        AssertUtil.isFalse(optional.isEmpty(), SystemFailEnum.USER_NULL_ERROR);
        //获取用户
        var userDO = optional.get();
        //密码作哈希
        var encodePassword = passwordEncoder.encode(userPartReqDTO.getPassword());
        userPartReqDTO.setPassword(encodePassword);

        //保存数据
        userDO = ConverterUtil.to(userPartReqDTO, UserDO.class);
        updateById(userDO);
    }

    @Override
    public UserRespDTO readUserAndMenuPermissionsByUserName(String userName) {
        var userResp = mybatisMapper.selectByUserName(userName);
        if (Objects.isNull(userResp)) {
            return ObjectUtil.getNull();
        }
        var permissions = readMenuPermissionsByUserName(userName);
        userResp.setPermissions(permissions);
        return userResp;
    }

    @Override
    public List<MenuRespDTO> readMenuTreesByUserName(String userName) {
        List<MenuRespDTO> menus;
        var menuTypes = Arrays.asList(MenuTypeEnum.DIRECTORY.getCode(), MenuTypeEnum.MENU.getCode());
        if (!SystemConstant.USER_NAME_ADMIN.equals(userName)) {
            menus = mybatisMapper.selectMenusByUserNameAndMenuTypes(userName, menuTypes);
        } else {
            menus = menuService.readListByTypes(menuTypes);
        }
        return toMenuTree(SystemConstant.MENU_ROOT_ID, menus);
    }

    @Override
    public List<String> readMenuPermissionsByUserName(String userName) {
        List<MenuRespDTO> menus;
        var menuTypes = Collections.singletonList(MenuTypeEnum.BUTTON.getCode());
        if (!SystemConstant.USER_NAME_ADMIN.equals(userName)) {
            menus = mybatisMapper.selectMenusByUserNameAndMenuTypes(userName, menuTypes);
        } else {
            menus = menuService.readListByTypes(menuTypes);
        }
        return menus.stream().map(MenuRespDTO::getPermission).toList();
    }


    private List<MenuRespDTO> toMenuTree(Long menuParentId, List<MenuRespDTO> menus) {
        var menuList = menus.stream()
                .filter(menu -> menu.getParentId().equals(menuParentId))
                .sorted(Comparator.comparing(MenuRespDTO::getSort))
                .toList();
        menuList.forEach(menu -> menu.setChildren(toMenuTree(menu.getId(), menus)));
        return menuList;
    }


}
