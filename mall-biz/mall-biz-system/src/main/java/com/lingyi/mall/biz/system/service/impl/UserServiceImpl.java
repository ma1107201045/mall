package com.lingyi.mall.biz.system.service.impl;

import cn.hutool.core.collection.CollUtil;
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
import com.lingyi.mall.biz.system.param.RoleParam;
import com.lingyi.mall.biz.system.param.UserParam;
import com.lingyi.mall.biz.system.repository.UserRepository;
import com.lingyi.mall.biz.system.service.MenuService;
import com.lingyi.mall.biz.system.service.RoleService;
import com.lingyi.mall.biz.system.service.UserRoleService;
import com.lingyi.mall.biz.system.service.UserService;
import com.lingyi.mall.biz.system.vo.RoleVO;
import com.lingyi.mall.biz.system.vo.UserVO;
import com.lingyi.mall.common.base.exception.BizException;
import com.lingyi.mall.common.base.param.BasePageParam;
import com.lingyi.mall.common.base.util.AssertUtil;
import com.lingyi.mall.common.util.ConverterUtil;
import com.lingyi.mall.common.util.ObjectUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

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
    public void deleteByIds(List<Long> ids) {
        userRepository.deleteAllById(ids);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateById(UserDTO userDTO) {
        Long id = userDTO.getId();
        //获取用户信息
        Optional<UserDO> optional = userRepository.findById(id);
        //判断用户是否不为空
        if (optional.isEmpty()) {
            throw new BizException(SystemFailEnum.USER_NULL_ERROR);
        }
        //获取用户
        UserDO userDO = optional.get();

        //校验用户名称是否相同
        Long newId = userMapper.selectIdByUserName(userDTO.getUserName());
        boolean result = Objects.nonNull(optional.get().getId()) && !Objects.equals(id, newId);

        //判断用户名称不存在
        AssertUtil.isFalse(result, SystemFailEnum.USER_NAME_EXIST_ERROR);
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
    public List<UserVO> readListByParam(UserParam userParam) {
        return userMapper.selectListByParam(userParam);
    }


    @Override
    public List<RoleVO> readRoleList() {
        return roleService.readListByParam(ObjectUtil.newInstance(RoleParam.class));
    }

    @Override
    public void editPartById(UserPartReqDTO userPartDTO) {
        UserVO userVO = userMapper.selectById(userPartDTO.getId());

        AssertUtil.notNull(userVO, SystemFailEnum.USER_NULL_ERROR);

        UserDO userDO = ConverterUtil.to(userVO, UserDO.class);

        String encodePassword = passwordEncoder.encode(userPartDTO.getPassword());
        userDO.setNickname(userPartDTO.getNickname());
        userDO.setPassword(encodePassword);
        userRepository.save(userDO);
    }

    @Override
    public UserResDTO findUserAndMenuPermissionsByUserName(String userName) {
        UserResDTO userResDTO = userMapper.selectByUserName(userName);
        if (ObjUtil.isNull(userResDTO)) {
            return userResDTO;
        }
        List<String> permissions = findMenuPermissionsByUserIdAndUserName(userResDTO.getUserId(), userName);
        userResDTO.setPermissions(permissions);
        return userResDTO;
    }


    @Override
    public List<MenuResDTO> findMenuTreeByUserNameAndMenuParentId(String userName, Long menuParentId) {
        List<MenuResDTO> menuResDTOList;
        List<Integer> menuTypes = CollUtil.newArrayList(MenuTypeEnum.DIRECTORY.getCode(), MenuTypeEnum.MENU.getCode());
        if (!SystemConstant.USER_NAME_ADMIN.equals(userName)) {
            menuResDTOList = userMapper.selectMenusByUserNameAndMenuTypesAndMenuParentId(userName, menuTypes, menuParentId);
        } else {
            menuResDTOList = menuService.findListByTypesAndParentId(menuTypes, menuParentId);
        }
        menuResDTOList.forEach(menuResDTO -> menuResDTO.setChildren(findMenuTreeByUserNameAndMenuParentId(userName, menuResDTO.getId())));
        return menuResDTOList;
    }

    @Override
    public List<String> findMenuPermissionsByUserIdAndUserName(Long userId, String userName) {
        Integer type = MenuTypeEnum.BUTTON.getCode();
        if (!SystemConstant.USER_NAME_ADMIN.equals(userName)) {
            return userMapper.selectMenuPermissionsByUserIdAndMenuType(userId, type);
        }
        return menuService.findPermissionsByType(type);
    }


}
