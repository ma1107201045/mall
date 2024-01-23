package com.lingyi.mall.common.orm.util;


import com.lingyi.mall.common.core.dto.BaseIdDTO;
import com.lingyi.mall.common.orm.entity.BaseIdDO;
import com.lingyi.mall.common.core.query.BasePageQuery;
import com.lingyi.mall.common.core.vo.BaseIdVO;

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
        QUERY extends BasePageQuery,
        DO extends BaseIdDO<ID>,
        ID extends Serializable> {

    /**
     * 增
     *
     * @param dto dto
     */
    ID create(DTO dto, Class<DO> clazz);

    /**
     * 增
     *
     * @param dto      dto
     * @param doEntity do
     */
    ID create(DTO dto, DO doEntity);

    /**
     * 增
     *
     * @param doEntity doEntity
     * @return ID
     */
    ID create(DO doEntity);


    /**
     * 批量增
     *
     * @param dto dto
     */
    List<ID> createList(List<DTO> dto, Class<DO> clazz);

    /**
     * 批量增
     *
     * @param dtoList      dtoList
     * @param doEntityList doEntityList
     * @return ID集
     */
    List<ID> createList(List<DTO> dtoList, List<DO> doEntityList);

    /**
     * 批量增
     *
     * @param doEntityList 。。
     * @return ID集合
     */
    List<ID> createList(List<DO> doEntityList);


    /**
     * 删除
     *
     * @param id id
     */
    void deleteById(ID id);

    /**
     * 批量删除
     *
     * @param ids ids
     */
    void deleteByIds(List<ID> ids);

    /**
     * @param dto   dto
     * @param clazz clazz
     */
    ID updateById(DTO dto, Class<DO> clazz);

    /**
     * 改
     *
     * @param dto      dto
     * @param doEntity doEntity
     */
    ID updateById(DTO dto, DO doEntity);

    /**
     * 改
     *
     * @param doEntity do
     */
    ID updateById(DO doEntity);


    /**
     * 改
     *
     * @param dto dto
     */
    ID updateById(DTO dto);

    /**
     * 批量改
     */
    List<ID> updateListById(List<DTO> dto, Class<DO> clazz);

    /**
     * 批量改
     */
    List<ID> updateListById(List<DTO> dto, List<DO> doEntityList);


    /**
     * 批量改
     */
    List<ID> updateListById(List<DO> doEntityList);


    /**
     * 批量改
     *
     * @param dtoList dtoList
     */
    List<ID> updateListByIdV2(List<DTO> dtoList);


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
     * @param query ..
     * @return Long
     */
    Long totalByParam(QUERY query);

    /**
     * 查多条
     *
     * @param query 参数
     * @return List<VO> List<VO>
     */
    List<VO> readListByParam(QUERY query);


}