package com.lingyi.mall.biz.system.mapper;

import com.lingyi.mall.biz.system.param.RoleParam;
import com.lingyi.mall.biz.system.vo.RoleVO;
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

    /**
     * 按照主键id查询
     *
     * @param id 主键id
     * @return RoleVO
     */
    RoleVO selectById(Long id);

    /**
     * 按照参数集查询
     *
     * @param roleParam 参数集
     * @return List<RoleVO>
     */
    List<RoleVO> selectListByParam(RoleParam roleParam);


}
