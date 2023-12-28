package com.lingyi.mall.biz.system.dao.mapper;

import com.lingyi.mall.biz.system.model.query.RoleQuery;
import com.lingyi.mall.biz.system.model.vo.RoleVO;
import com.lingyi.mall.common.core.query.BasePageQuery;
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
public interface RoleMapper extends MybatisMapperImplementation<RoleVO, RoleQuery, Long> {


    /**
     * @return 角色列表
     */
    List<RoleVO> selectList(BasePageQuery basePageQuery);


}
