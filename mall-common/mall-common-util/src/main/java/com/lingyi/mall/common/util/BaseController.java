package com.lingyi.mall.common.util;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.lingyi.mall.common.bean.entity.BaseIdEntity;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/5/5 17:08
 * @description
 */
public interface BaseController<T extends BaseIdEntity, ID> {

    ServerResponse<Void> save(T t);

    ServerResponse<Void> removeByIds(Iterable<ID> ids);

    ServerResponse<Void> updateById(ID id, T t);

    ServerResponse<T> getById(ID id);

    ServerResponse<IPage<T>> getListPageAndCondition(PageParam pageParam, T t);
}
