package com.lingyi.mall.biz.system.service.impl;

import cn.hutool.core.collection.CollUtil;
import com.lingyi.mall.api.system.response.MenuResponse;
import com.lingyi.mall.biz.system.model.dto.MenuDTO;
import com.lingyi.mall.biz.system.model.entity.MenuDO;
import com.lingyi.mall.biz.system.enums.MenuTypeEnum;
import com.lingyi.mall.biz.system.enums.SystemFailEnum;
import com.lingyi.mall.biz.system.dao.mapper.MenuMapper;
import com.lingyi.mall.biz.system.model.query.MenuQuery;
import com.lingyi.mall.biz.system.dao.repository.MenuRepository;
import com.lingyi.mall.biz.system.service.MenuService;
import com.lingyi.mall.biz.system.model.vo.MenuVO;
import com.lingyi.mall.common.core.constant.BaseConstant;
import com.lingyi.mall.common.core.util.AssertUtil;
import com.lingyi.mall.common.orm.util.BaseServiceProImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
public class MenuServiceImpl extends BaseServiceProImpl<MenuRepository, MenuMapper, MenuDTO, MenuVO, MenuQuery, MenuDO, Long>
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
    public List<MenuVO> readTree() {
        var menuParam = new MenuQuery();
        menuParam.setSortField("sort");
        menuParam.setSortDirection("ASC");
        var menus = readListByParam(menuParam);
        return toTree(BaseConstant.TREE_ROOT_ID, menus);
    }


    @Override
    public List<MenuResponse> readListByTypes(List<Integer> types) {
        return menuMapper.selectListByTypes(types);
    }


    private void verifyData(MenuDTO menuDTO) {
        var parentId = menuDTO.getParentId();
        var type = menuDTO.getType();

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
                .collect(Collectors.toList());
    }
}


