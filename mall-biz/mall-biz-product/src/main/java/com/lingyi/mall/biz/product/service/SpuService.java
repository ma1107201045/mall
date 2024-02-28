package com.lingyi.mall.biz.product.service;

import com.lingyi.mall.biz.product.model.dto.SpuDTO;
import com.lingyi.mall.biz.product.model.entity.SpuDO;
import com.lingyi.mall.biz.product.model.query.SpuQuery;
import com.lingyi.mall.biz.product.model.vo.SpuVO;
import com.lingyi.mall.common.orm.util.BaseServicePro;

import java.util.List;

/**
 * @Author: maweiyan
 * @Email: 1107201045@qq.com
 * @DateTime: 2023/8/31 9:29
 * @Description:
 */
public interface SpuService extends BaseServicePro<SpuDTO, SpuVO, SpuQuery, SpuDO, Long> {


    /**
     * 添加
     *
     * @param spuDTO 。。
     */
    void add(SpuDTO spuDTO);

    /**
     * 修改
     *
     * @param spuDTO 。。
     */
    void editById(SpuDTO spuDTO);

    /**
     * 批量移除
     *
     * @param ids ..
     */

    void removeByIds(List<Long> ids);


    /**
     * 分页查询
     *
     * @param id ..
     * @return ..
     */
    SpuVO getById(Long id);

    /**
     * 分页查询
     *
     * @param spuQuery ..
     * @return ...
     */
    List<SpuVO> getListByQuery(SpuQuery spuQuery);
}
