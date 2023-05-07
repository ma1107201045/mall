package com.lingyi.mall.common.util;

import java.io.Serializable;
import java.util.List;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/5/5 17:08
 * @description
 */
public interface BaseController<T extends Serializable, ID> {

    ServerResponse<Void> save(T t);

    ServerResponse<Void> removeByIds(Iterable<ID> ids);

    ServerResponse<Void> updateById(ID id, T t);

    ServerResponse<T> getById(ID id);

    ServerResponse<List<T>> getListPageAndCondition(PageParam pageParam, T t);
}
