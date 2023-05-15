package com.lingyi.mall.biz.system.b.mapper;

import com.lingyi.mall.api.system.b.param.RoleParam;
import com.lingyi.mall.api.system.b.vo.RoleMenuVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/5/5 15:05
 * @description
 */
@Mapper
public interface MbsRoleMenuMapper {

    RoleMenuVO selectById(Long id);

    List<RoleMenuVO> selectListByParam(RoleParam roleParam);
}
