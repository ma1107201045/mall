package com.lingyi.mall.biz.system.b.mapper;

import com.lingyi.mall.api.system.b.param.RoleParam;
import com.lingyi.mall.api.system.b.vo.RoleVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/5/5 14:58
 * @description
 */
@Mapper
public interface MbsRoleMapper {

    RoleVO selectById(Long id);

    List<RoleVO> selectListByParam(RoleParam roleParam);
}
