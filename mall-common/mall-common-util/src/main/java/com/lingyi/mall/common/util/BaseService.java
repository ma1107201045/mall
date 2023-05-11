package com.lingyi.mall.common.util;


import com.lingyi.mall.common.bean.dto.BaseBackgroundPageDTO;

import java.io.Serializable;
import java.util.List;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/5/4 17:08
 * @description
 */
public interface BaseService<T extends Serializable, ID> {

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
     * @param baseBackgroundPageDTO 分页信息
     * @param t                     t
     * @return List<T>
     */
    List<T> findListByPageAndCondition(BaseBackgroundPageDTO baseBackgroundPageDTO, T t);


}
