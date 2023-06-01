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
import com.lingyi.mall.common.base.param.BasePageParam;
import com.lingyi.mall.common.base.util.AssertUtil;
import com.lingyi.mall.common.util.ConverterUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

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

    private final UserRepository mbsUserRepository;

    private final UserMapper mbsUserMapper;

    private final UserRoleService mbsUserRoleService;

    private final MenuService menuService;


    @Override
    @Transactional(rollbackFor = Exception.class)
    public void add(UserDTO userDTO) {
        //通过用户名称获取用户id
        Long id = mbsUserMapper.selectIdByUserName(userDTO.getUserName());
        //判断用户名称不存在
        AssertUtil.isNull(id, SystemFailEnum.USER_NAME_EXIST_ERROR);
        //密码加密
        String encodePassword = passwordEncoder.encode(userDTO.getPassword());
        //设置加密密码
        userDTO.setPassword(encodePassword);
        //转换
        User user = ConverterUtil.to(userDTO, User.class);
        //保存
        mbsUserRepository.save(user);
        //保存用户角色信息
        mbsUserRoleService.addList(user.getId(), userDTO.getRoleIds());
    }

    @Override
    public void removeByIds(List<Long> ids) {
        mbsUserRepository.deleteAllById(ids);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void editById(UserDTO userDTO) {
        //获取用户id
        Long id = userDTO.getId();
        //断言userId不为空
        AssertUtil.notNull(id, SystemFailEnum.USER_ID_NULL_ERROR);

        //通过用户名称获取用户id
        Long newId = mbsUserMapper.selectIdByUserName(userDTO.getUserName());
        boolean result = Objects.nonNull(id) && !Objects.equals(id, newId);

        //判断用户名称不存在
        AssertUtil.isFalse(result, SystemFailEnum.USER_NAME_EXIST_ERROR);
        //密码加密
        String encodePassword = passwordEncoder.encode(userDTO.getPassword());
        //设置加密密码
        userDTO.setPassword(encodePassword);
        //DTO转换Entity
        User user = ConverterUtil.to(userDTO, User.class);
        //更新
        mbsUserRepository.save(user);
        //删除用户角色集
        mbsUserRoleService.removeByUserId(id);
        //保存用户角色信息
        mbsUserRoleService.addList(id, userDTO.getRoleIds());
    }

    @Override
    public UserVO findById(Long id) {
        return mbsUserMapper.selectById(id);
    }

    @Override
    public List<UserVO> findListByPageAndParam(BasePageParam basePageParam, UserParam userParam) {
        PageHelper.startPage(basePageParam.getCurrentPage(), basePageParam.getPageSize(), basePageParam.getSort());
        return mbsUserMapper.selectListByParam(userParam);
    }


    @Override
    public void editPartById(UserPartDTO userPartDTO) {
        UserVO userVO = mbsUserMapper.selectById(userPartDTO.getId());

        AssertUtil.notNull(userVO, SystemFailEnum.USER_NOT_EXIST_ERROR);

        User user = ConverterUtil.to(userVO, User.class);

        String encodePassword = passwordEncoder.encode(userPartDTO.getPassword());
        user.setNickname(userPartDTO.getNickname());
        user.setPassword(encodePassword);
        mbsUserRepository.save(user);
    }

    @Override
    public UserVO findUserAndMenuPermissionsByUserName(String userName) {
        UserVO userVO = mbsUserMapper.selectByUserName(userName);
        if (ObjUtil.isNull(userVO)) {
            return userVO;
        }
        List<String> permissions;
        Integer type = MenuType.BUTTON.getCode();
        if (!SystemConstant.USER_NAME_ADMIN.equals(userName)) {
            permissions = mbsUserMapper.selectMenuPermissionsByUserIdAndMenuType(userVO.getUserId(), type);
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
            menuVOList = mbsUserMapper.selectMenusByUserNameAndMenuTypesAndMenuParentId(userName, menuTypes, menuParentId);
        } else {
            menuVOList = menuService.findListByTypesAndParentId(menuTypes, menuParentId);
        }
        menuVOList.forEach(menuTreeVO -> menuTreeVO.setMenus(findMenuTreeByUserNameAndMenuParentId(userName, menuParentId)));
        return menuVOList;
    }

}
