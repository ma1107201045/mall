package com.lingyi.mall.biz.system.service.impl;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.ObjUtil;
import com.github.pagehelper.PageHelper;
import com.lingyi.mall.api.system.dto.UserPartDTO;
import com.lingyi.mall.biz.system.constant.SystemConstant;
import com.lingyi.mall.api.system.dto.UserDTO;
import com.lingyi.mall.api.system.entity.User;
import com.lingyi.mall.api.system.enums.SystemFailEnum;
import com.lingyi.mall.api.system.enums.MenuType;
import com.lingyi.mall.api.system.param.UserParam;
import com.lingyi.mall.api.system.vo.MenuVO;
import com.lingyi.mall.api.system.vo.UserVO;
import com.lingyi.mall.biz.system.mapper.UserMapper;
import com.lingyi.mall.biz.system.repository.UserRepository;
import com.lingyi.mall.biz.system.service.MenuService;
import com.lingyi.mall.biz.system.service.UserRoleService;
import com.lingyi.mall.biz.system.service.UserService;
import com.lingyi.mall.common.base.exception.BizException;
import com.lingyi.mall.common.base.param.BasePageParam;
import com.lingyi.mall.common.base.util.AssertUtil;
import com.lingyi.mall.common.util.ConverterUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    private final MenuService menuService;


    @Override
    @Transactional(rollbackFor = Exception.class)
    public void add(UserDTO userDTO) {
        //通过用户名称获取用户id
        Long id = userMapper.selectIdByUserName(userDTO.getUserName());
        //判断用户名称不存在
        AssertUtil.isNull(id, SystemFailEnum.USER_NAME_EXIST_ERROR);
        //密码加密
        String encodePassword = passwordEncoder.encode(userDTO.getPassword());
        //设置加密密码
        userDTO.setPassword(encodePassword);
        //DTO转换Entity
        User user = ConverterUtil.to(userDTO, User.class);
        //保存
        userRepository.save(user);
        //保存用户角色信息
        userRoleService.addList(user.getId(), userDTO.getRoleIds());
    }

    @Override
    public void removeByIds(List<Long> ids) {
        userRepository.deleteAllById(ids);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void editById(UserDTO userDTO) {
        Long id = userDTO.getId();
        //获取用户信息
        Optional<User> optional = userRepository.findById(id);
        //判断用户是否不为空
        if (optional.isEmpty()) {
            throw new BizException(SystemFailEnum.USER_NULL_ERROR);
        }
        //获取用户
        User user = optional.get();

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
        ConverterUtil.to(userDTO, user);
        //更新
        userRepository.save(user);
        //删除用户角色集
        userRoleService.removeByUserId(id);
        //保存用户角色信息
        userRoleService.addList(id, userDTO.getRoleIds());
    }

    @Override
    public UserVO findById(Long id) {
        return userMapper.selectById(id);
    }

    @Override
    public List<UserVO> findListByPageAndParam(BasePageParam basePageParam, UserParam userParam) {
        PageHelper.startPage(basePageParam.getCurrentPage(), basePageParam.getPageSize(), basePageParam.getSort());
        return userMapper.selectListByParam(userParam);
    }


    @Override
    public void editPartById(UserPartDTO userPartDTO) {
        UserVO userVO = userMapper.selectById(userPartDTO.getId());

        AssertUtil.notNull(userVO, SystemFailEnum.USER_NULL_ERROR);

        User user = ConverterUtil.to(userVO, User.class);

        String encodePassword = passwordEncoder.encode(userPartDTO.getPassword());
        user.setNickname(userPartDTO.getNickname());
        user.setPassword(encodePassword);
        userRepository.save(user);
    }

    @Override
    public UserVO findUserAndMenuPermissionsByUserName(String userName) {
        UserVO userVO = userMapper.selectByUserName(userName);
        if (ObjUtil.isNull(userVO)) {
            return userVO;
        }
        List<String> permissions;
        Integer type = MenuType.BUTTON.getCode();
        if (!SystemConstant.USER_NAME_ADMIN.equals(userName)) {
            permissions = userMapper.selectMenuPermissionsByUserIdAndMenuType(userVO.getUserId(), type);
        } else {
            permissions = menuService.findPermissionsByType(type);
        }
        userVO.setPermissions(permissions);
        return userVO;
    }


    @Override
    public List<MenuVO> findMenuTreeByUserNameAndMenuParentId(String userName, Long menuParentId) {
        List<MenuVO> menuVOList;
        List<Integer> menuTypes = CollUtil.newArrayList(MenuType.DIRECTORY.getCode(), MenuType.MENU.getCode());
        if (!SystemConstant.USER_NAME_ADMIN.equals(userName)) {
            menuVOList = userMapper.selectMenusByUserNameAndMenuTypesAndMenuParentId(userName, menuTypes, menuParentId);
        } else {
            menuVOList = menuService.findListByTypesAndParentId(menuTypes, menuParentId);
        }
        menuVOList.forEach(menuTreeVO -> menuTreeVO.setMenus(findMenuTreeByUserNameAndMenuParentId(userName, menuParentId)));
        return menuVOList;
    }

}
