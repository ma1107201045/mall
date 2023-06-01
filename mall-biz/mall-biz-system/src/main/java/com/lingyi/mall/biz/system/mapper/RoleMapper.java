package com.lingyi.mall.biz.system.mapper;

import com.lingyi.mall.api.system.param.RoleParam;
import com.lingyi.mall.api.system.vo.RoleVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/5/5 14:58
 * @description
 */
@Mapper
public interface RoleMapper {

    RoleVO selectById(Long id);

    List<RoleVO> selectListByParam(RoleParam roleParam);
}
