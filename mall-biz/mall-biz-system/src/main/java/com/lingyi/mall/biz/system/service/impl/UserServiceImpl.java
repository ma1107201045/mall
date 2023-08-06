package com.lingyi.mall.biz.system.service.impl;

import cn.hutool.core.util.ObjUtil;
import com.lingyi.mall.api.system.dto.MenuResDTO;
import com.lingyi.mall.api.system.dto.UserPartReqDTO;
import com.lingyi.mall.api.system.dto.UserResDTO;
import com.lingyi.mall.biz.system.constant.SystemConstant;
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
import com.lingyi.mall.common.base.param.BasePageParam;
import com.lingyi.mall.common.base.util.AssertUtil;
import com.lingyi.mall.common.base.util.ConverterUtil;
import com.lingyi.mall.common.base.util.ObjectUtil;
import lombok.RequiredArgsConstructor;
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
public class UserServiceImpl implements UserService {

    private final PasswordEncoder passwordEncoder;

    private final UserRepository userRepository;

    private final UserMapper userMapper;

    private final UserRoleService userRoleService;

    private final RoleService roleService;

    private final MenuService menuService;


    @Override
    @Transactional(rollbackFor = Exception.class)
    public void create(UserDTO userDTO) {
        //通过用户名称获取用户id
        Long id = userMapper.selectIdByUserName(userDTO.getUserName());
        //判断用户名称不存在
        AssertUtil.isNull(id, SystemFailEnum.USER_NAME_EXIST_ERROR);
        //密码加密
        String encodePassword = passwordEncoder.encode(userDTO.getPassword());
        //设置加密密码
        userDTO.setPassword(encodePassword);
        //DTO转换Entity
        UserDO userDO = ConverterUtil.to(userDTO, UserDO.class);
        //保存
        userRepository.save(userDO);
        //保存用户角色信息
        userRoleService.createList(userDO.getId(), userDTO.getRoleIds());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteByIds(List<Long> ids) {
        boolean flag = userRepository.findAllById(ids).stream()
                .anyMatch(userDO -> SystemConstant.USER_NAME_ADMIN.equals(userDO.getUserName()));
        AssertUtil.isFalse(flag, SystemFailEnum.USER_NAME_ADMIN_DELETE_ERROR);
        userRepository.deleteAllById(ids);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateById(UserDTO userDTO) {
        Long id = userDTO.getId();
        //获取用户信息
        Optional<UserDO> optional = userRepository.findById(id);
        //断言用户是否不为空
        AssertUtil.isFalse(optional.isEmpty(), SystemFailEnum.USER_NULL_ERROR);
        //获取用户
        UserDO userDO = optional.get();
        //断言用户是否admin
        AssertUtil.isFalse(SystemConstant.USER_NAME_ADMIN.equals(userDO.getUserName()), SystemFailEnum.USER_NAME_ADMIN_UPDATE_ERROR);
        //断言用户名称是否相同
        Long newId = userMapper.selectIdByUserName(userDTO.getUserName());
        boolean flag = Objects.nonNull(newId) && !Objects.equals(id, newId);

        //判断用户名称不存在
        AssertUtil.isFalse(flag, SystemFailEnum.USER_NAME_EXIST_ERROR);
        //密码加密
        String encodePassword = passwordEncoder.encode(userDTO.getPassword());
        //设置加密密码
        userDTO.setPassword(encodePassword);
        //DTO转换Entity
        ConverterUtil.to(userDTO, userDO);
        //更新
        userRepository.save(userDO);
        //删除用户角色集
        userRoleService.deleteByUserId(id);
        //保存用户角色信息
        userRoleService.createList(id, userDTO.getRoleIds());
    }

    @Override
    public UserVO readById(Long id) {
        return userMapper.selectById(id);
    }

    @Override
    public Long countByParam(UserParam userParam) {
        return userMapper.countByParam(userParam);
    }

    @Override
    public List<UserVO> readListByParam(UserParam userParam) {
        return userMapper.selectListByParam(userParam);
    }


    @Override
    public List<RoleVO> readRoleList(BasePageParam basePageParam) {
        return roleService.readList(basePageParam);
    }

    @Override
    public void updatePartById(UserPartReqDTO userPartDTO) {
        UserVO userVO = userMapper.selectById(userPartDTO.getId());

        AssertUtil.notNull(userVO, SystemFailEnum.USER_NULL_ERROR);

        UserDO userDO = ConverterUtil.to(userVO, UserDO.class);

        String encodePassword = passwordEncoder.encode(userPartDTO.getPassword());
        userDO.setNickname(userPartDTO.getNickname());
        userDO.setPassword(encodePassword);
        userRepository.save(userDO);
    }

    @Override
    public UserResDTO readUserAndMenuPermissionsByUserName(String userName) {
        UserResDTO userResDTO = userMapper.selectByUserName(userName);
        if (ObjUtil.isNull(userResDTO)) {
            return userResDTO;
        }
        List<String> permissions = readMenuPermissionsByUserName(userName);
        userResDTO.setPermissions(permissions);
        return userResDTO;
    }

    @Override
    public List<MenuResDTO> readMenuTreeByUserName(String userName) {
        List<MenuResDTO> menuResDTOList;
        List<Integer> menuTypes = Arrays.asList(MenuTypeEnum.DIRECTORY.getCode(), MenuTypeEnum.MENU.getCode());
        if (!SystemConstant.USER_NAME_ADMIN.equals(userName)) {
            menuResDTOList = userMapper.selectMenusByUserNameAndMenuTypes(userName, menuTypes);
        } else {
            menuResDTOList = menuService.readListByTypes(menuTypes);
        }
        return toMenuTree(SystemConstant.MENU_ROOT_ID, menuResDTOList);
    }

    @Override
    public List<String> readMenuPermissionsByUserName(String userName) {
        List<MenuResDTO> menuResDTOList;
        List<Integer> menuTypes = Collections.singletonList(MenuTypeEnum.BUTTON.getCode());
        if (!SystemConstant.USER_NAME_ADMIN.equals(userName)) {
            menuResDTOList = userMapper.selectMenusByUserNameAndMenuTypes(userName, menuTypes);
        } else {
            menuResDTOList = menuService.readListByTypes(menuTypes);
        }
        return menuResDTOList.stream().map(MenuResDTO::getPermission).toList();
    }


    private List<MenuResDTO> toMenuTree(Long menuParentId, List<MenuResDTO> menuResDTOList) {
        List<MenuResDTO> menus = menuResDTOList.stream()
                .filter(menuResDTO -> menuResDTO.getParentId().equals(menuParentId))
                .sorted(Comparator.comparing(MenuResDTO::getSort))
                .toList();
        menus.forEach(menuResDTO -> menuResDTO.setChildren(toMenuTree(menuResDTO.getId(), menuResDTOList)));
        return menus;
    }


}
