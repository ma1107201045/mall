package com.lingyi.mall.common.base.util;


import com.lingyi.mall.common.base.param.BasePageParam;

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
    void removeByIds(List<ID> ids);

    /**
     * 修改
     *
     * @param dto dto
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
     * @param param       查找参数
     * @return List<VO>
     */
    List<VO> findListByPageAndParam(BasePageParam basePageDTO, PARAM param);


}
