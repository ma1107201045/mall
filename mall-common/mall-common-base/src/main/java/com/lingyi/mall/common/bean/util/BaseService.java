package com.lingyi.mall.common.bean.util;


import com.lingyi.mall.common.bean.param.BasePageParam;

import java.io.Serializable;
import java.util.List;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/5/4 17:08
 * @description
 */
public interface BaseService<DTO extends Serializable, PARAM extends Serializable, VO extends Serializable, ID extends Serializable> {

    /**
     * 添加
     *
     * @param dto dto
     */
    void add(DTO dto);

    /**
     * 批量删除
     *
     * @param ids ids
     */
    void removeByIds(Iterable<ID> ids);

    /**
     * 修改
     *
     * @param w w
     */
    void editById(DTO dto);

    /**
     * 查找
     *
     * @param id id
     * @return t
     */
    VO findById(ID id);

    /**
     * 查找列表
     *
     * @param basePageDTO 分页信息
     * @return List<T>
     */
    List<VO> findListByPageAndParam(BasePageParam basePageDTO, PARAM param);


}
