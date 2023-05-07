package com.lingyi.mall.common.util;


import com.lingyi.mall.common.bean.entity.BaseIdEntity;

import java.util.List;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/5/4 17:08
 * @description
 */
public interface BaseService<T extends BaseIdEntity, ID> {

    /**
     * 添加
     *
     * @param t t
     */
    void add(T t);

    /**
     * 批量删除
     *
     * @param ids ids
     */
    void removeByIds(Iterable<ID> ids);

    /**
     * 修改
     *
     * @param t t
     */
    void editById(T t);

    /**
     * 查找
     *
     * @param id id
     * @return t
     */
    T findById(ID id);

    /**
     * 查找列表
     *
     * @param pageParam 分页信息
     * @param t         t
     * @return List<T>
     */
    List<T> findListByPageAndCondition(PageParam pageParam, T t);


}
