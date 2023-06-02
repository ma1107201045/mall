package com.lingyi.mall.biz.system.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollUtil;
import com.github.pagehelper.PageHelper;
import com.lingyi.mall.biz.system.constant.SystemConstant;
import com.lingyi.mall.api.system.dto.MenuDTO;
import com.lingyi.mall.api.system.entity.Menu;
import com.lingyi.mall.api.system.enums.SystemFailEnum;
import com.lingyi.mall.api.system.enums.MenuType;
import com.lingyi.mall.api.system.param.MenuParam;
import com.lingyi.mall.api.system.vo.MenuVO;
import com.lingyi.mall.biz.system.mapper.MenuMapper;
import com.lingyi.mall.biz.system.repository.MenuRepository;
import com.lingyi.mall.biz.system.service.MenuService;
import com.lingyi.mall.common.base.exception.BizException;
import com.lingyi.mall.common.base.param.BasePageParam;
import com.lingyi.mall.common.base.util.AssertUtil;
import com.lingyi.mall.common.util.ConverterUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

/**
 * @Author: maweiyan
 * @Email 1107201045@qq.com
 * @DateTime: 2023/5/7 15:28
 * @Description:
 */
@Service
@RequiredArgsConstructor
public class MenuServiceImpl implements MenuService {

    private final MenuRepository menuRepository;

    private final MenuMapper menuMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void add(MenuDTO menuDTO) {
        //校验数据
        verifyAndGetData(menuDTO, false);
        //DTO转换Entity
        Menu menu = BeanUtil.copyProperties(menuDTO, Menu.class);
        //保存
        menuRepository.save(menu);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void removeByIds(List<Long> ids) {
        if (CollUtil.isNotEmpty(ids)) {
            menuRepository.deleteAllById(ids);
            removeByIds(menuMapper.selectIdsByParentIds(ids));
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void editById(MenuDTO menuDTO) {
        //校验数据
        Menu menu = verifyAndGetData(menuDTO, true);
        //DTO转换Entity
        ConverterUtil.to(menuDTO, menu);
        //更新
        menuRepository.save(menu);
    }

    @Override
    public MenuVO findById(Long id) {
        return menuMapper.selectById(id);
    }

    @Override
    public List<MenuVO> findListByPageAndParam(BasePageParam basePageParam, MenuParam menuParam) {
        PageHelper.startPage(basePageParam.getCurrentPage(), basePageParam.getPageSize(), basePageParam.getSort());
        return menuMapper.selectListByParam(menuParam);
    }


    @Override
    public List<MenuVO> findTreeByParentId(Long parentId) {
        List<MenuVO> menus = menuMapper.selectListByParentId(parentId);
        menus.forEach(menu -> menu.setMenus(findTreeByParentId(menu.getId())));
        return menus;
    }

    @Override
    public List<String> findPermissionsByType(Integer type) {
        return menuMapper.selectPermissionsByType(type);
    }

    @Override
    public List<MenuVO> findListByTypesAndParentId(List<Integer> types, Long parentId) {
        return menuMapper.selectListByTypesAndParentId(types, parentId);
    }


    private Menu verifyAndGetData(MenuDTO menuDTO, boolean isEdit) {
        Integer type = menuDTO.getType();
        Long parentId = menuDTO.getParentId();
        //断言目录父级parentId只能为-1
        boolean result01 = Objects.equals(MenuType.DIRECTORY.getCode(), type) && Objects.equals(SystemConstant.MENU_ROOT_ID, parentId);
        AssertUtil.isTrue(result01, SystemFailEnum.MENU_DIRECTORY_PARENT_ERROR);
        //断言菜单类型不能为空
        Integer newType = menuMapper.selectTypeById(parentId);
        AssertUtil.notNull(newType, SystemFailEnum.MENU_TYPE_NOT_EXIST_ERROR);

        //断言菜单父级parentId对应的菜单只能为目录类型
        boolean result02 = Objects.equals(MenuType.MENU.getCode(), type) && Objects.equals(MenuType.DIRECTORY.getCode(), newType);
        AssertUtil.isTrue(result02, SystemFailEnum.MENU_MENU_PARENT_ERROR);

        //断言按钮父级parentId对应的菜单只能为菜单类型
        boolean result03 = Objects.equals(MenuType.BUTTON.getCode(), type) && Objects.equals(MenuType.MENU.getCode(), newType);
        AssertUtil.isTrue(result03, SystemFailEnum.MENU_BUTTON_PARENT_ERROR);
        Menu menu = null;
        if (isEdit) {
            Optional<Menu> optional = menuRepository.findById(menuDTO.getId());
            //判断用户是否不为空
            if (optional.isEmpty()) {
                throw new BizException(SystemFailEnum.MENU_NULL_ERROR);
            }
            menu = optional.get();
        }
        return menu;
    }

}
