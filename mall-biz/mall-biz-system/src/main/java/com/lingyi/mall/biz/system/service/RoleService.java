package com.lingyi.mall.biz.system.service;

import com.lingyi.mall.biz.system.dto.RoleDTO;
import com.lingyi.mall.biz.system.entity.RoleDO;
import com.lingyi.mall.biz.system.param.RoleParam;
import com.lingyi.mall.biz.system.vo.MenuVO;
import com.lingyi.mall.biz.system.vo.RoleVO;
import com.lingyi.mall.common.orm.param.BasePageParam;
import com.lingyi.mall.common.orm.util.BaseService;
import com.lingyi.mall.common.orm.util.BaseServicePro;

import java.util.List;

/**
 * @Author: maweiyan
 * @Email 1107201045@qq.com
 * @DateTime: 2023/5/10 23:14
 * @Description:
 */
public interface RoleService extends BaseServicePro<RoleDTO, RoleVO, RoleParam, RoleDO, Long> {
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
