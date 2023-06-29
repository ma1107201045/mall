package com.lingyi.mall.biz.system.service;

import com.lingyi.mall.biz.system.dto.RoleDTO;
import com.lingyi.mall.biz.system.param.RoleParam;
import com.lingyi.mall.biz.system.param.UserParam;
import com.lingyi.mall.biz.system.vo.MenuVO;
import com.lingyi.mall.biz.system.vo.RoleVO;
import com.lingyi.mall.common.base.util.BaseService;

import java.util.List;

/**
 * @Author: maweiyan
 * @Email 1107201045@qq.com
 * @DateTime: 2023/5/10 23:14
 * @Description:
 */
public interface RoleService extends BaseService<RoleDTO, RoleParam, RoleVO, Long> {

    /**
     * count
     *
     * @param roleParam 角色条件
     * @return 条数
     */
    Long countByParam(RoleParam roleParam);

    /**
     * 读取角色集
     *
     * @return List<RoleVO>
     */
    List<RoleVO> readList();

    /**
     * 读取菜单树
     *
     * @return List<RoleVO>
     */
    List<MenuVO> readMenuTree();

}
