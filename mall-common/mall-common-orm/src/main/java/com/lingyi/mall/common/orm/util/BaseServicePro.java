package com.lingyi.mall.common.orm.util;


import com.lingyi.mall.common.orm.dto.BaseIdDTO;
import com.lingyi.mall.common.orm.entity.BaseIdDO;
import com.lingyi.mall.common.orm.param.BasePageParam;
import com.lingyi.mall.common.orm.vo.BaseIdVO;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

/**
 * @Author: maweiyan
 * @Email: 1107201045@qq.com
 * @DateTime: 2023/9/9 10:07
 * @Description:
 */
public interface BaseServicePro<
        DTO extends BaseIdDTO<ID>,
        VO extends BaseIdVO<ID>,
        PARAM extends BasePageParam,
        DO extends BaseIdDO,
        ID extends Serializable> {

    /**
     * 增
     *
     * @param dto dto
     */
    void create(DTO dto, Class<DO> clazz);

    /**
     * 增
     *
     * @param dto      dto
     * @param doEntity do
     */
    void create(DTO dto, DO doEntity);

    /**
     * 增
     *
     * @param doEntity do
     */
    void create(DO doEntity);

    /**
     * 批量删
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
     * 改
     *
     * @param dto dto
     */
    void updateById(DTO dto);

    /**
     * 改
     *
     * @param doEntity do
     */
    void updateById(DO doEntity);

    /**
     * 查
     *
     * @param id id
     * @return t
     */
    VO readById(ID id);


    /**
     * 统计
     *
     * @param param ..
     * @return Long
     */
    Long totalByParam(PARAM param);

    /**
     * 查多条
     *
     * @param param 参数
     * @return List<VO> List<VO>
     */
    List<VO> readListByParam(PARAM param);


}