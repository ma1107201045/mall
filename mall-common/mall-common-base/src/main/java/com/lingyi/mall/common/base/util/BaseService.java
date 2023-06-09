package com.lingyi.mall.common.base.util;


import com.github.pagehelper.PageHelper;
import com.lingyi.mall.common.base.query.BasePageQuery;

import java.io.Serializable;
import java.util.List;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/5/4 17:08
 * @description
 */
public interface BaseService<DTO extends Serializable, QUERY extends Serializable, VO extends Serializable, ID extends Serializable> {

    /**
     * 添加
     *
     * @param dto dto
     */
    void create(DTO dto);

    /**
     * 批量删除
     *
     * @param ids ids
     */
    void deleteByIds(List<ID> ids);

    /**
     * 修改
     *
     * @param dto dto
     */
    void updateById(DTO dto);

    /**
     * 查找
     *
     * @param id id
     * @return t
     */
    VO readById(ID id);

    /**
     * 查找列表
     *
     * @param pageQuery 分页信息
     * @param query     查找参数
     * @return List<VO>
     */
    List<VO> readListByPageAndQuery(BasePageQuery pageQuery, QUERY query);


    /**
     * 开始分页
     *
     * @param pageQuery pageQuery
     */
    default void startPage(BasePageQuery pageQuery) {
        PageHelper.startPage(pageQuery.getCurrentPage(), pageQuery.getPageSize(), pageQuery.getSort());
    }


}
