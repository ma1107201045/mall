package com.lingyi.mall.common.jdbc.util;



import com.lingyi.mall.common.jdbc.dto.BaseDTO;
import com.lingyi.mall.common.jdbc.entity.BaseIdDO;
import com.lingyi.mall.common.jdbc.param.BasePageParam;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

/**
 * @Author: maweiyan
 * @Email: 1107201045@qq.com
 * @DateTime: 2023/9/9 10:07
 * @Description:
 */
public interface BaseServiceTest<
        T extends BaseIdDO,
        DTO extends BaseDTO<ID>,
        PARAM extends BasePageParam,
        VO,
        ID extends Serializable> {

    /**
     * 添加
     *
     * @param dto dto
     */
    void create(DTO dto, Class<T> clazz);

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