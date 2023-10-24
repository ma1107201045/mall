package com.lingyi.mall.biz.info.dao.mapper;

import com.lingyi.mall.biz.info.model.param.LogParam;
import com.lingyi.mall.biz.info.model.vo.LogVO;
import com.lingyi.mall.common.orm.mybatis.MybatisMapperImplementation;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/7/12 14:17
 * @description
 */
@Mapper
public interface LogMapper extends MybatisMapperImplementation<LogVO, LogParam, Long> {
}
