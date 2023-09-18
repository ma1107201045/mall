package com.lingyi.mall.biz.system.mapper;

import com.lingyi.mall.biz.system.param.RoleParam;
import com.lingyi.mall.biz.system.vo.RoleVO;
import com.lingyi.mall.common.core.param.BasePageParam;
import com.lingyi.mall.common.orm.mybatis.MybatisMapperImplementation;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/5/5 14:58
 * @description
 */
@Mapper
public interface RoleMapper extends MybatisMapperImplementation<RoleVO, RoleParam, Long> {


    /**
     * @return 角色列表
     */
    List<RoleVO> selectList(BasePageParam basePageParam);


}
