package com.lingyi.mall.biz.system.service.impl;

import cn.hutool.core.collection.CollUtil;
import com.lingyi.mall.api.system.dto.MenuRespDTO;
import com.lingyi.mall.biz.system.constant.SystemConstant;
import com.lingyi.mall.biz.system.dto.MenuDTO;
import com.lingyi.mall.biz.system.entity.MenuDO;
import com.lingyi.mall.biz.system.enums.MenuTypeEnum;
import com.lingyi.mall.biz.system.enums.SystemFailEnum;
import com.lingyi.mall.biz.system.mapper.MenuMapper;
import com.lingyi.mall.biz.system.param.MenuParam;
import com.lingyi.mall.biz.system.repository.MenuRepository;
import com.lingyi.mall.biz.system.service.MenuService;
import com.lingyi.mall.biz.system.vo.MenuVO;
import com.lingyi.mall.common.core.util.AssertUtil;
import com.lingyi.mall.common.core.util.ConverterUtil;
import com.lingyi.mall.common.core.util.ObjectUtil;
import com.lingyi.mall.common.orm.util.BaseServiceProImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @Author: maweiyan
 * @Email 1107201045@qq.com
 * @DateTime: 2023/5/7 15:28
 * @Description:
 */
@Service
@RequiredArgsConstructor
public class MenuServiceImpl extends BaseServiceProImpl<MenuRepository, MenuMapper, MenuDTO, MenuVO, MenuParam, MenuDO, Long>
        implements MenuService {

    private final MenuRepository menuRepository;

    private final MenuMapper menuMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void create(MenuDTO menuDTO) {
        //校验数据
        verifyData(menuDTO);
        //保存
        create(menuDTO, MenuDO.class);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteByIds(List<Long> ids) {
        if (CollUtil.isEmpty(ids)) {
            return;
        }
        menuRepository.deleteAllById(ids);
        super.deleteByIds(menuMapper.selectIdsByParentIds(ids));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateById(MenuDTO menuDTO) {
        //校验数据
        verifyData(menuDTO);
        //更新
        super.updateById(menuDTO);
    }

    @Override
    public MenuVO readById(Long id) {
        return menuMapper.selectById(id);
    }

    @Override
    public List<MenuVO> readListByParam(MenuParam menuParam) {
        return menuMapper.selectListByParam(menuParam);
    }

    @Override
    public List<MenuVO> readTree() {
        MenuParam menuParam = new MenuParam();
        menuParam.setSortField("sort");
        menuParam.setSortDirection("ASC");
        var menus = readListByParam(menuParam);
        return toTree(SystemConstant.MENU_ROOT_ID, menus);
    }


    @Override
    public List<MenuRespDTO> readListByTypes(List<Integer> types) {
        return menuMapper.selectListByTypes(types);
    }


    private void verifyData(MenuDTO menuDTO) {
        var type = menuDTO.getType();
        var parentId = menuDTO.getParentId();

        //查询父级类型
        var newType = menuMapper.selectTypeById(parentId);

        //断言目录父级为root或者是目录
        if (Objects.equals(MenuTypeEnum.DIRECTORY.getCode(), type)) {
            boolean result = Objects.isNull(newType) || Objects.equals(MenuTypeEnum.DIRECTORY.getCode(), newType);
            AssertUtil.isTrue(result, SystemFailEnum.MENU_DIRECTORY_PARENT_ERROR);
        }
        //断言菜单父级为目录
        if (Objects.equals(MenuTypeEnum.MENU.getCode(), type)) {
            var result = Objects.isNull(newType) || Objects.equals(MenuTypeEnum.DIRECTORY.getCode(), newType);
            AssertUtil.isTrue(result, SystemFailEnum.MENU_MENU_PARENT_ERROR);
        }

        //断言按钮父级为菜单
        if (Objects.equals(MenuTypeEnum.BUTTON.getCode(), type)) {
            var result = Objects.equals(MenuTypeEnum.MENU.getCode(), newType);
            AssertUtil.isTrue(result, SystemFailEnum.MENU_BUTTON_PARENT_ERROR);
        }
    }


    private List<MenuVO> toTree(Long parentId, List<MenuVO> menus) {
        return menus.stream()
                .filter(menu -> menu.getParentId().equals(parentId))
                .peek(menu -> menu.setChildren(toTree(menu.getId(), menus)))
//                .sorted(Comparator.comparing(MenuVO::getSort))
                .collect(Collectors.toList());
    }
}


