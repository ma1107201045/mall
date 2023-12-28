package com.lingyi.mall.biz.info.dao.mapper;

import com.lingyi.mall.biz.info.model.param.InfoLogQuery;
import com.lingyi.mall.biz.info.model.vo.InfoLogVO;
import com.lingyi.mall.common.orm.mybatis.MybatisMapperImplementation;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/7/12 14:17
 * @description
 */
@Mapper
public interface InfoLogMapper extends MybatisMapperImplementation<InfoLogVO, InfoLogQuery, Long> {
}
