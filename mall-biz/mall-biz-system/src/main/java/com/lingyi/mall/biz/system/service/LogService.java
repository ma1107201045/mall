package com.lingyi.mall.biz.system.service;

import com.lingyi.mall.api.system.dto.LogReqDTO;
import com.lingyi.mall.biz.system.entity.LogDO;
import com.lingyi.mall.common.base.util.BaseService;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/6/3 9:32
 * @description
 */
public interface LogService extends BaseService<LogDO, LogDO, LogDO, Long> {


    /**
     * 创建
     *
     * @param logReqDTO logReqDTO
     */
    void create(LogReqDTO logReqDTO);


}
