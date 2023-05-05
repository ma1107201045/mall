package com.lingyi.mall.common.util;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.lingyi.mall.common.bean.entity.BaseIdEntity;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/5/4 17:08
 * @description
 */
public interface BaseService<T extends BaseIdEntity, ID> {

    void add(T t);

    void removeByIds(Iterable<ID> ids);

    void editById(T t);

    T findById(ID id);

    IPage<T> findListPageAndCondition(IPage<T> iPage, T t);


}
