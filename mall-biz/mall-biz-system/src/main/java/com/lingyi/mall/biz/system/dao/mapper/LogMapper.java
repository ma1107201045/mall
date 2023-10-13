package com.lingyi.mall.biz.system.dao.mapper;

import com.lingyi.mall.biz.system.model.param.LogParam;
import com.lingyi.mall.biz.system.model.vo.LogVO;
import com.lingyi.mall.common.orm.mybatis.MybatisMapperImplementation;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/6/3 9:30
 * @description
 */
@Mapper
public interface LogMapper extends MybatisMapperImplementation<LogVO, LogParam, Long> {

}
