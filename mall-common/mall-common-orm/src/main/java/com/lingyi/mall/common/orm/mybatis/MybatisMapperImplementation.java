package com.lingyi.mall.common.orm.mybatis;


import com.lingyi.mall.common.core.query.BasePageQuery;
import com.lingyi.mall.common.core.vo.BaseIdVO;

import java.io.Serializable;
import java.util.List;

/**
 * @Author: maweiyan
 * @Email: 1107201045@qq.com
 * @DateTime: 2023/8/31 16:07
 * @Description:
 */
public interface MybatisMapperImplementation<VO extends BaseIdVO<ID>, QUERY extends BasePageQuery, ID extends Serializable> {

    /**
     * 按照id查询
     *
     * @param id 主键id
     * @return VO
     */
    VO selectById(ID id);

    /**
     * 按照分页信息和条件查询统计数量
     *
     * @param query 查询参数
     * @return 条目
     */
    Long countByParam(QUERY query);

    /**
     * 按照分页信息和条件查询
     *
     * @param query 查询参数
     * @return List<VO>
     */
    List<VO> selectListByParam(QUERY query);
}
