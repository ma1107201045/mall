package com.lingyi.mall.common.jdbc.util;


import com.lingyi.mall.common.jdbc.param.BasePageParam;

import java.io.Serializable;
import java.util.List;

/**
 * @Author: maweiyan
 * @Email: 1107201045@qq.com
 * @DateTime: 2023/8/31 16:07
 * @Description:
 */
public interface MybatisMapper<ID extends Serializable, PARMA extends BasePageParam, VO> {

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
     * @param parma 参数
     * @return 条目
     */
    Long countByParam(PARMA parma);

    /**
     * 按照分页信息和条件查询
     *
     * @param parma 参数
     * @return List<VO>
     */
    List<VO> selectListByParam(PARMA parma);
}
