package com.lingyi.mall.common.orm.util;


import com.lingyi.mall.common.orm.dto.BaseIdDTO;
import com.lingyi.mall.common.orm.param.BasePageParam;
import com.lingyi.mall.common.orm.vo.BaseIdVO;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/5/4 17:08
 * @description
 */
public interface BaseService<DTO extends BaseIdDTO<Long>, VO extends BaseIdVO<Long>, PARAM extends BasePageParam, ID extends Serializable> {

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
     * 删除
     *
     * @param id id
     */
    default void deleteById(ID id) {
        this.deleteByIds(Collections.singletonList(id));
    }

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
     * @param param 参数
     * @return List<VO> List<VO>
     */
    List<VO> readListByParam(PARAM param);


}
