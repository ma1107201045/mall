package com.lingyi.mall.biz.system.service;

import com.lingyi.mall.biz.system.model.dto.RoleDTO;
import com.lingyi.mall.biz.system.model.entity.RoleDO;
import com.lingyi.mall.biz.system.model.query.RoleQuery;
import com.lingyi.mall.biz.system.model.vo.MenuVO;
import com.lingyi.mall.biz.system.model.vo.RoleVO;
import com.lingyi.mall.common.orm.util.BaseServicePro;

import java.util.List;

/**
 * @Author: maweiyan
 * @Email 1107201045@qq.com
 * @DateTime: 2023/5/10 23:14
 * @Description:
 */
public interface RoleService extends BaseServicePro<RoleDTO, RoleVO, RoleQuery, RoleDO, Long> {
    /**
     * 保存
     *
     * @param roleDTO ..
     */
    void create(RoleDTO roleDTO);



    /**
     * 读取菜单树
     *
     * @return List<RoleVO>
     */
    List<MenuVO> readMenuTree();

}
