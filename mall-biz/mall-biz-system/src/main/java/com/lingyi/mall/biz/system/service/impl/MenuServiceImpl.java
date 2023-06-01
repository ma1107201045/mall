package com.lingyi.mall.biz.system.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollUtil;
import com.github.pagehelper.PageHelper;
import com.lingyi.mall.biz.system.constant.MbsConstant;
import com.lingyi.mall.api.system.dto.MenuDTO;
import com.lingyi.mall.api.system.entity.Menu;
import com.lingyi.mall.api.system.enums.FailEnum;
import com.lingyi.mall.api.system.enums.MenuType;
import com.lingyi.mall.api.system.param.MenuParam;
import com.lingyi.mall.api.system.vo.MenuVO;
import com.lingyi.mall.biz.system.mapper.MenuMapper;
import com.lingyi.mall.biz.system.repository.MenuRepository;
import com.lingyi.mall.biz.system.service.MenuService;
import com.lingyi.mall.common.base.param.BasePageParam;
import com.lingyi.mall.common.base.util.AssertUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

/**
 * @Author: maweiyan
 * @Email 1107201045@qq.com
 * @DateTime: 2023/5/7 15:28
 * @Description:
 */
@Service
@RequiredArgsConstructor
public class MenuServiceImpl implements MenuService {

    private final MenuRepository mbsMenuRepository;

    private final MenuMapper mbsMenuMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void add(MenuDTO menuDTO) {
        //校验数据
        verifyData(menuDTO, false);
        //DTO转换Entity
        Menu menu = BeanUtil.copyProperties(menuDTO, Menu.class);
        //保存
        mbsMenuRepository.save(menu);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void removeByIds(List<Long> ids) {
        if (CollUtil.isNotEmpty(ids)) {
            mbsMenuRepository.deleteAllById(ids);
            removeByIds(mbsMenuMapper.selectIdsByParentIds(ids));
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void editById(MenuDTO menuDTO) {
        //校验数据
        verifyData(menuDTO, true);
        //DTO转换Entity
        Menu menu = BeanUtil.copyProperties(menuDTO, Menu.class);
        //更新
        mbsMenuRepository.save(menu);
    }

    @Override
    public MenuVO findById(Long id) {
        return mbsMenuMapper.selectById(id);
    }

    @Override
    public List<MenuVO> findListByPageAndParam(BasePageParam basePageParam, MenuParam menuParam) {
        PageHelper.startPage(basePageParam.getCurrentPage(), basePageParam.getPageSize(), basePageParam.getSort());
        return mbsMenuMapper.selectListByParam(menuParam);
    }


    @Override
    public List<MenuVO> findTreeByParentId(Long parentId) {
        List<MenuVO> menus = mbsMenuMapper.selectListByParentId(parentId);
        menus.forEach(menu -> menu.setMenus(findTreeByParentId(menu.getId())));
        return menus;
    }

    @Override
    public List<String> findPermissionsByType(Integer type) {
        return mbsMenuMapper.selectPermissionsByType(type);
    }

    @Override
    public List<MenuVO> findListByTypesAndParentId(List<Integer> types, Long parentId) {
        return mbsMenuMapper.selectListByTypesAndParentId(types, parentId);
    }


    private void verifyData(MenuDTO menuDTO, boolean isEdit) {
        Integer type = menuDTO.getType();
        Long parentId = menuDTO.getParentId();
        //断言目录父级parentId只能为-1
        boolean result01 = Objects.equals(MenuType.DIRECTORY.getCode(), type) && Objects.equals(MbsConstant.MENU_ROOT_ID, parentId);
        AssertUtil.isTrue(result01, FailEnum.MENU_DIRECTORY_PARENT_ERROR);
        //断言菜单类型不能为空
        Integer newType = mbsMenuMapper.selectTypeById(parentId);
        AssertUtil.notNull(newType, FailEnum.MENU_TYPE_NOT_EXIST_ERROR);

        //断言菜单父级parentId对应的菜单只能为目录类型
        boolean result02 = Objects.equals(MenuType.MENU.getCode(), type) && Objects.equals(MenuType.DIRECTORY.getCode(), newType);
        AssertUtil.isTrue(result02, FailEnum.MENU_MENU_PARENT_ERROR);

        //断言按钮父级parentId对应的菜单只能为菜单类型
        boolean result03 = Objects.equals(MenuType.BUTTON.getCode(), type) && Objects.equals(MenuType.MENU.getCode(), newType);
        AssertUtil.isTrue(result03, FailEnum.MENU_BUTTON_PARENT_ERROR);
        if (isEdit) {
            //断言menuId不为空
            AssertUtil.notNull(menuDTO.getId(), FailEnum.MENU_ID_NULL_ERROR);
        }
    }

}
