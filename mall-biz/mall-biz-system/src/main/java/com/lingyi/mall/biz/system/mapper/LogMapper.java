package com.lingyi.mall.biz.system.mapper;

import com.lingyi.mall.api.system.entity.Log;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/6/3 9:30
 * @description
 */
@Mapper
public interface LogMapper {


    /**
     * 按照id查询
     *
     * @param id 主键id
     * @return 日志
     */
    Log selectById(Long id);

    /**
     * 按照分页信息和条件查询
     *
     * @param log 日志信息
     * @return List<Log>
     */
    List<Log> selectListByParam(Log log);
}
